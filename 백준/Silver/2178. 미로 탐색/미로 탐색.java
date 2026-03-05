import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 배열 정보
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int[][] visited = new int[n][m];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int ny = curr[0] + dy[idx];
                int nx = curr[1] + dx[idx];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (board[ny].charAt(nx) == '1' && visited[ny][nx] == 0) {
                        visited[ny][nx] = visited[curr[0]][curr[1]] + 1;
                        queue.offer(new int[] {ny, nx});
                    }
                }
            }
            
        }

        System.out.println(visited[n-1][m-1]);
    }
}
