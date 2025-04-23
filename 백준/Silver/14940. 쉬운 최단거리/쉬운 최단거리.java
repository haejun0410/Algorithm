import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];

        Queue<point> queue = new LinkedList<>();
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.offer(new point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            point pos = queue.poll();

            for(int i=0; i<4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[pos.y][pos.x] + 1;
                        queue.offer(new point(ny, nx));
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(visited[i][j]).append(" ");
                }
                
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static class point{
        int y, x;

        public point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
