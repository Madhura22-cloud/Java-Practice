import java.util.*;

public class TwoScoutsPaths {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int startA, startB, outpost;
    static int minTowns = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            if (!sc.hasNextInt()) {
                System.out.println("Impossible");
                return;
            }
            N = sc.nextInt();
            if (!sc.hasNextInt()) {
                System.out.println("Impossible");
                return;
            }
            M = sc.nextInt();

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < M; i++) {
                if (!sc.hasNextInt()) {
                    System.out.println("Impossible");
                    return;
                }
                int a = sc.nextInt();
                if (!sc.hasNextInt()) {
                    System.out.println("Impossible");
                    return;
                }
                int b = sc.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }

            if (!sc.hasNextInt()) {
                System.out.println("Impossible");
                return;
            }
            startA = sc.nextInt();
            if (!sc.hasNextInt()) {
                System.out.println("Impossible");
                return;
            }
            startB = sc.nextInt();

            if (!sc.hasNextInt()) {
                System.out.println("Impossible");
                return;
            }
            outpost = sc.nextInt();
        } catch (NoSuchElementException e) {
            System.out.println("Impossible");
            return;
        }

        boolean[] visitedA = new boolean[N + 1];
        boolean[] visitedB = new boolean[N + 1];

        ArrayList<ArrayList<Integer>> pathsA = new ArrayList<>();
        ArrayList<Integer> currentPathA = new ArrayList<>();
        visitedA[startA] = true;
        currentPathA.add(startA);
        dfsPaths(startA, outpost, visitedA, currentPathA, pathsA);
        visitedA[startA] = false;
        currentPathA.remove(currentPathA.size() - 1);

        if (pathsA.isEmpty()) {
            System.out.println("Impossible");
            return;
        }

        minTowns = Integer.MAX_VALUE;
        boolean possible = false;
        for (ArrayList<Integer> pathA : pathsA) {
            boolean[] visitedAForB = new boolean[N + 1];
            for (int v : pathA) visitedAForB[v] = true;

            boolean[] visitedBForDFS = new boolean[N + 1];
            visitedBForDFS[startB] = true;
            ArrayList<Integer> currentPathB = new ArrayList<>();
            currentPathB.add(startB);

            possible |= dfsPathsCheckB(startB, outpost, visitedBForDFS, visitedAForB, currentPathB, pathA);
        }

        if (possible) {
            System.out.println(minTowns);
        } else {
            System.out.println("Impossible");
        }
    }

    static void dfsPaths(int u, int dest, boolean[] visited, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> res) {
        if (u == dest) {
            res.add(new ArrayList<>(currPath));
            return;
        }
        for (int v : graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                currPath.add(v);
                dfsPaths(v, dest, visited, currPath, res);
                currPath.remove(currPath.size() - 1);
                visited[v] = false;
            }
        }
    }

    static boolean dfsPathsCheckB(int u, int dest, boolean[] visitedB, boolean[] visitedA, ArrayList<Integer> currPathB, ArrayList<Integer> pathA) {
        if (u == dest) {
            HashSet<Integer> uniqueTowns = new HashSet<>(pathA);
            uniqueTowns.addAll(currPathB);
            int count = uniqueTowns.size();
            if (count < minTowns) {
                minTowns = count;
            }
            return true;
        }
        boolean found = false;
        for (int v : graph[u]) {
            if (!visitedB[v] && (!visitedA[v] || v == outpost)) {
                visitedB[v] = true;
                currPathB.add(v);
                found |= dfsPathsCheckB(v, dest, visitedB, visitedA, currPathB, pathA);
                currPathB.remove(currPathB.size() - 1);
                visitedB[v] = false;
            }
        }
        return found;
    }
}
