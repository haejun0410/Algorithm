import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int y, x, dist;
        Node(int y, int x, int dist) {
            this.y = y; this.x = x; this.dist = dist;
        }
        @Override
        public int compareTo(Node o) { return this.dist - o.dist; }
    }

    static int n, k, sy, sx, ey, ex;
    static int[][] board, dists;
    static Node[][] parent;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
        ex = Integer.parseInt(st.nextToken());
        
        k = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++) Arrays.fill(board[i], 1);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int numPoints = Integer.parseInt(st.nextToken());
            int cy = Integer.parseInt(st.nextToken());
            int cx = Integer.parseInt(st.nextToken());
            board[cy][cx] = k;

            for (int j = 1; j < numPoints; j++) {
                int ny = Integer.parseInt(st.nextToken());
                int nx = Integer.parseInt(st.nextToken());
                
                while (cy != ny || cx != nx) {
                    if (cy < ny) cy++; else if (cy > ny) cy--;
                    if (cx < nx) cx++; else if (cx > nx) cx--;
                    board[cy][cx] = k;
                }
            }
        }

        dijkstra();
        printPath();
    }

    static void dijkstra() {
        dists = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(dists[i], Integer.MAX_VALUE);
        parent = new Node[n + 1][n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dists[sy][sx] = board[sy][sx];
        pq.add(new Node(sy, sx, dists[sy][sx]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.dist > dists[curr.y][curr.x]) continue;
            if (curr.y == ey && curr.x == ex) break;

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny >= 1 && ny <= n && nx >= 1 && nx <= n) {
                    if (dists[ny][nx] > curr.dist + board[ny][nx]) {
                        dists[ny][nx] = curr.dist + board[ny][nx];
                        parent[ny][nx] = curr;
                        pq.add(new Node(ny, nx, dists[ny][nx]));
                    }
                }
            }
        }
    }

    static void printPath() {
        System.out.println(dists[ey][ex]);

        Deque<Node> points = new ArrayDeque<>();
        Node curr = new Node(ey, ex, 0);
        points.push(curr);

        while (parent[curr.y][curr.x] != null) {
            Node p = parent[curr.y][curr.x];
            Node gp = parent[p.y][p.x];

            if (gp != null) {

                if (!((curr.y == p.y && p.y == gp.y) || (curr.x == p.x && p.x == gp.x))) {
                    points.push(p);
                }
            } else {
                points.push(p);
            }
            curr = p;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(points.size()).append(" ");
        while (!points.isEmpty()) {
            Node p = points.pop();
            sb.append(p.y).append(" ").append(p.x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}