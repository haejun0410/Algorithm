import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int n,m;
    static int cheese;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        int cheeseCount = 0;
        int time = 0;

        while (cheese != 0) {
            cheeseCount = cheese;
            time++;
            visited = new boolean[n][m];
            bfs();
        }

        System.out.println(time);
        System.out.println(cheeseCount);
        
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] == 0) {
                        queue.offer(new int[] {ny, nx});
                    }
                    else {
                        cheese--;
                        map[ny][nx] = 0;
                    }
                }
            }
        }
    }
}
