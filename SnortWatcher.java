import java.io.*;
import java.nio.file.*;

public class SnortWatcher {

    public static void main(String[] args) throws Exception {
        // Path to snort binary and config - adjust to your system
        String snortBinary = "/usr/sbin/snort";
        String snortConf = "/etc/snort/snort.conf";
        String interfaceName = "eth0"; // change to your interface
        String alertFile = "/var/log/snort/alert"; // simple text alert file (depends on snort config)

        // Start Snort in IDS mode with console output (optional)
        ProcessBuilder pb = new ProcessBuilder(snortBinary, "-c", snortConf, "-i", interfaceName, "-A", "console");
        pb.redirectErrorStream(true);
        System.out.println("Starting Snort (you will likely need sudo privileges)...");
        Process snortProc = pb.start();

        // Print Snort console output in a separate thread
        new Thread(() -> {
            try (BufferedReader r = new BufferedReader(new InputStreamReader(snortProc.getInputStream()))) {
                String line;
                while ((line = r.readLine()) != null) {
                    System.out.println("[Snort] " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Watch the alert file (polling) and print new lines (simple tail -f replacement)
        Path alertPath = Paths.get(alertFile);
        if (!Files.exists(alertPath)) {
            System.err.println("Alert file not found: " + alertFile);
            System.err.println("Check snort.conf output settings or choose the correct alert file.");
        } else {
            System.out.println("Tailing alert file: " + alertFile);
            tailFile(alertPath);
        }

        // Note: cleanup and process termination not handled here for brevity.
    }

    // Simple tail -f: print lines appended to file
    private static void tailFile(Path path) {
        try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r")) {
            long filePointer = file.length();
            while (true) {
                long fileLength = file.length();
                if (fileLength < filePointer) {
                    // Log rotated/truncated
                    filePointer = fileLength;
                }
                if (fileLength > filePointer) {
                    file.seek(filePointer);
                    String line;
                    while ((line = file.readLine()) != null) {
                        // Decode as UTF-8 if necessary; Java readLine reads ISO-8859-1; adapt if needed.
                        System.out.println("[ALERT] " + line);
                    }
                    filePointer = file.getFilePointer();
                }
                Thread.sleep(1000); // poll interval
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

