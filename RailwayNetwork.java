import java.util.*;

public class RailwayNetwork {
    static int N; // number of lines defining initial stations
    static Map<String, Integer> stationMap = new HashMap<>();
    static List<String> stationList = new ArrayList<>();
    static List<Set<Integer>> adj = new ArrayList<>();
    static Map<Integer, Set<Integer>> restrictionMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine().trim());

        // Read station connections
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }
            String[] parts = line.split("\\s+");
            String src = parts[0];
            int srcId = getStationId(src);
            ensureAdjSize(srcId);

            for (int j = 1; j < parts.length; j++) {
                int destId = getStationId(parts[j]);
                ensureAdjSize(destId);

                adj.get(srcId).add(destId);
                adj.get(destId).add(srcId);
            }
        }

        int Q = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < Q; i++) {
            String cmdLine = "";
            while (sc.hasNextLine()) {
                cmdLine = sc.nextLine().trim();
                if (!cmdLine.isEmpty()) break;
            }
            if (cmdLine.contains(" to ")) {
                String[] parts = cmdLine.split(" to ");
                String source = parts[0].trim();
                String dest = parts[1].trim();
                System.out.println(canTravel(source, dest) ? "yes" : "no");
            } else if (cmdLine.contains(" connects ")) {
                String[] parts = cmdLine.split(" connects ");
                connectStations(parts[0].trim(), parts[1].trim());
            } else if (cmdLine.contains(" disconnects ")) {
                String[] parts = cmdLine.split(" disconnects ");
                disconnectStations(parts[0].trim(), parts[1].trim());
            }
        }

        if (!sc.hasNextLine()) {
            System.out.println("Impossible");
            return;
        }

        int R = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < R; i++) {
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine().trim();
                if (!line.isEmpty()) break;
            }
            String[] parts = line.split("\\s+");
            if (parts.length < 1) continue;
            int sourceId = getStationId(parts[0]);
            Set<Integer> restricted = new HashSet<>();
            for (int j = 1; j < parts.length; j++) {
                restricted.add(getStationId(parts[j]));
            }
            restrictionMap.put(sourceId, restricted);
        }
    }

    static int getStationId(String s) {
        if (!stationMap.containsKey(s)) {
            stationMap.put(s, stationList.size());
            stationList.add(s);
            adj.add(new HashSet<>());
        }
        return stationMap.get(s);
    }

    static void ensureAdjSize(int id) {
        while (adj.size() <= id) {
            adj.add(new HashSet<>());
        }
    }

    static void connectStations(String s1, String s2) {
        int id1 = getStationId(s1);
        int id2 = getStationId(s2);
        ensureAdjSize(id1);
        ensureAdjSize(id2);
        adj.get(id1).add(id2);
        adj.get(id2).add(id1);
    }

    static void disconnectStations(String s1, String s2) {
        Integer id1 = stationMap.get(s1);
        Integer id2 = stationMap.get(s2);
        if (id1 == null || id2 == null) return;
        adj.get(id1).remove(id2);
        adj.get(id2).remove(id1);
    }

    static boolean canTravel(String source, String dest) {
        Integer srcId = stationMap.get(source);
        Integer dstId = stationMap.get(dest);
        if (srcId == null || dstId == null) return false;

        Set<Integer> restricted = restrictionMap.getOrDefault(srcId, Collections.emptySet());
        boolean[] visited = new boolean[stationList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(srcId);
        visited[srcId] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dstId) return true;

            for (int nxt : adj.get(curr)) {
                if (!visited[nxt] && !restricted.contains(nxt)) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
        return false;
    }
}
