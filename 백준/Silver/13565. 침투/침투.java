import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new ArrayDeque<>();

        for(int j=0; j<m; j++) {
            if (board[0][j] == '0' && !visited[0][j]) {
                queue.offer(new int[] {0, j});
                visited[0][j] = true;

                while(!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    for(int i=0; i<4; i++) {
                        int ny = curr[0] + dy[i];
                        int nx = curr[1] + dx[i];

                        if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                            if (board[ny][nx] == '0') {
                                queue.offer(new int[] {ny,nx});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }
        }

        boolean flag = false;

        for(int j=0; j<m; j++) {
            if (visited[n-1][j]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
