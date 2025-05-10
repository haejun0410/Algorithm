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

        Character[][] board = new Character[n][m];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String arr = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = arr.charAt(j);
                if (board[i][j] == 'I') {
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                    if (board[ny][nx] == 'O') {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                    else if (board[ny][nx] == 'P') {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                        cnt++;
                    }
                }
            }
        }

        if (cnt == 0) {
            System.out.println("TT");
        }
        else {
            System.out.println(cnt);
        }
    }
}

