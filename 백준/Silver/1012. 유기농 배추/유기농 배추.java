import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int n,m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int testcase=0; testcase<t; testcase++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            int count = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(i,j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static class Point  {
        int x, y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }

}
