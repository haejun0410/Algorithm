import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int n;

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        
        int maxHeight = -1;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int height = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(height, maxHeight);
                map[i][j] = height;
            }
        }

        int maxCount = 0;

        for (int height=0; height<=maxHeight; height++) {
            visited = new boolean[n][n];
            int count = 0;

            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (map[i][j] >= height && !visited[i][j]) {
                        count++;
                        dfs(i, j, height);
                    }
                }
            }
            maxCount = Math.max(count, maxCount);
        }

        System.out.println(maxCount);

        
    }

    public static void dfs(int y, int x, int height) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];        
            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (map[ny][nx] >= height && !visited[ny][nx]) {
                    dfs(ny, nx, height);
                }
            }
        }
    }

}
