import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] visited;
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

        int time = 0;

        while (cheese != 0) {
            time++;
            visited = new int[n][m];
            bfs();
        }
        System.out.println(time);
        
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (map[ny][nx] == 0) {
                        if (visited[ny][nx] == 0) {
                            visited[ny][nx] = 1;
                            queue.offer(new int[] {ny, nx});
                        }
                    }
                    else {
                        if (visited[ny][nx] <= 1) {
                            visited[ny][nx]++;
                            if (visited[ny][nx] == 2) {
                                cheese--;
                                map[ny][nx] = 0;
                            }
                        }
                    }
                    
                }
            }
        }
    }
}
