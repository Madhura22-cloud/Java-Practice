import java.util.*;

public class BrickWall {
    static int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        char[][] wall = new char[N][N];
        int sx = -1, sy = -1, destX = -1, destY = -1;
        
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            List<Character> expanded = new ArrayList<>();
            for (int j = 0; j < line.length(); ) {
                int k = j;
                StringBuilder sb = new StringBuilder();
                while (k < line.length() && Character.isDigit(line.charAt(k))) {
                    sb.append(line.charAt(k++));
                }
                if (sb.length() == 0) {
                    throw new IllegalArgumentException("Invalid input format at row " + (i+1) + ", position " + j);
                }
                int count = Integer.parseInt(sb.toString());
                if (k >= line.length()) {
                    throw new IllegalArgumentException("Invalid input format at row " + (i+1) + ", position " + j);
                }
                char type = line.charAt(k);
                for (int m = 0; m < count; m++) {
                    expanded.add(type);
                }
                j = k + 1;
            }
            if (expanded.size() != N) {
                throw new IllegalArgumentException("Row " + (i+1) + " does not expand to correct length.");
            }
            for (int m = 0; m < N; m++) {
                wall[i][m] = expanded.get(m);
                if (wall[i][m] == 'S') {
                    sx = i;
                    sy = m;
                }
                if (wall[i][m] == 'D') {
                    destX = i;
                    destY = m;
                }
            }
        }

        System.out.println(bfs(wall, sx, sy, destX, destY, N));
    }

    static int bfs(char[][] wall, int sx, int sy, int destX, int destY, int N) {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy, 0));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.x == destX && curr.y == destY) {
                return curr.cost;
            }
            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (wall[nx][ny] == 'G' || wall[nx][ny] == 'D') {
                        visited[nx][ny] = true;
                        int addCost = wall[nx][ny] == 'G' ? 1 : 0;
                        q.add(new Node(nx, ny, curr.cost + addCost));
                    }
                }
            }
        }
        return -1; // unreachable
    }
}
