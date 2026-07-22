import org.pcap4j.core.*;
import org.pcap4j.packet.Packet;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class PcapCapture {

    public static void main(String[] args) throws PcapNativeException, NotOpenException {
        // List devices
        List<PcapNetworkInterface> devs = Pcaps.findAllDevs();
        if (devs == null || devs.isEmpty()) {
            System.err.println("No network interfaces found. Make sure libpcap / npcap is installed.");
            return;
        }

        System.out.println("Available interfaces:");
        for (int i = 0; i < devs.size(); i++) {
            System.out.printf("[%d] %s (%s)%n", i, devs.get(i).getName(), devs.get(i).getDescription());
        }

        // Choose interface index (for exam/demo pick 0 or pass as arg)
        int index = 0;
        if (args.length > 0) {
            try { index = Integer.parseInt(args[0]); } catch (Exception e) { index = 0; }
        }
        PcapNetworkInterface nif = devs.get(index);
        System.out.println("Using interface: " + nif.getName());

        int snapLen = 65536; // bytes
        PromiscuousMode mode = PromiscuousMode.PROMISCUOUS;
        int timeout = 10; // ms

        // Open handle for capture
        final PcapHandle handle = nif.openLive(snapLen, mode, timeout);

        // Optional: set a capture filter (BPF) to limit traffic (comment out to capture all)
        // handle.setFilter("tcp or udp or icmp", BpfProgram.BpfCompileMode.OPTIMIZE);

        // Dump to pcap file
        String pcapFile = "capture.pcap";
        final PcapDumper dumper = handle.dumpOpen(pcapFile);

        System.out.println("Started capture. Press Ctrl+C to stop (or will auto-capture 100 packets).");

        // Capture loop (here limit to 100 packets for demo)
        int maxPackets = 100;
        for (int i = 0; i < maxPackets; i++) {
            try {
                Packet packet = handle.getNextPacketEx(); // blocks until packet or timeout
                Instant ts = Instant.ofEpochMilli(handle.getTimestampInts() * 1000L + handle.getTimestampMicros() / 1000);
                // Print brief summary
                String summary = String.format("[%s] Len=%d  %s",
                        ts.toString(), packet.length(), packet);
                System.out.println(summary);

                // Write packet to pcap file
                dumper.dump(packet, handle.getTimestamp());
            } catch (TimeoutException te) {
                // no packet in timeout window; continue
            } catch (PcapNativeException | NotOpenException | EOFException e) {
                e.printStackTrace();
                break;
            }
        }

        // cleanup
        dumper.close();
        handle.close();

        System.out.println("Capture finished. Saved to " + pcapFile);
        System.out.println("Open capture.pcap in Wireshark for deeper analysis.");
    }
}

