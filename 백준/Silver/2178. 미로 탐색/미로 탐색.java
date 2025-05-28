import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for(int i=0; i<n; i++) {
            String arr = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = arr.charAt(j);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(visited[i], -1);
        }

        queue.offer(new int[] {0, 0});
        visited[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (visited[ny][nx] == -1 && board[ny][nx] == '1') {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = visited[current[0]][current[1]] + 1;
                    }
                }
            }
        }

        System.out.println(visited[n-1][m-1] + 1);

    }
}
