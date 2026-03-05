import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static class Point implements Comparable<Point> {
        int r, c, h;
        Point(int r, int c, int h) {
            this.r = r; this.c = c; this.h = h;
        }
        @Override
        public int compareTo(Point o) {
            return o.h - this.h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                points.add(new Point(i, j, board[i][j]));
            }
        }

        Collections.sort(points);
        parent = new int[n * n];
        Arrays.fill(parent, -1);

        int maxSafeZones = 1;
        int currentSafeZones = 0;
        boolean[][] active = new boolean[n][n];

        int idx = 0;
        for (int h = points.get(0).h; h >= 1; h--) {
            while (idx < points.size() && points.get(idx).h == h) {
                Point p = points.get(idx);
                active[p.r][p.c] = true;
                parent[p.r * n + p.c] = p.r * n + p.c;
                currentSafeZones++;

                for (int d = 0; d < 4; d++) {
                    int nr = p.r + dy[d];
                    int nc = p.c + dx[d];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && active[nr][nc]) {
                        if (union(p.r * n + p.c, nr * n + nc)) {
                            currentSafeZones--;
                        }
                    }
                }
                idx++;
            }
            maxSafeZones = Math.max(maxSafeZones, currentSafeZones);
        }

        System.out.println(maxSafeZones);
    }

    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }
}