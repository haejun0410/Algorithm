import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] board;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            int cnt = countIce();

            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            if (cnt >= 2) {
                System.out.println(time);
                return;
            }

            melt();
            time++;
        }


    }

    public static int countIce() {
        int cnt = 0;

        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    cnt++;
                    queue.offer(new int[] {i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();

                        for(int k=0; k<4; k++) {
                            int ny = current[0] + dy[k];
                            int nx = current[1] + dx[k];

                            if (ny >= 0 && ny < n && nx >= 0 && nx < m && board[ny][nx] != 0 && !visited[ny][nx]) {
                                queue.offer(new int[] {ny, nx});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }   
            }
        }
        return cnt;
    }

    public static void melt() {
        int[][] temp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] > 0) {
                    int cntSea = 0;

                    for(int k=0; k<4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny >= 0 && ny < n && nx >= 0 && nx < m && board[ny][nx] == 0) {
                            cntSea++;
                        }
                    }
                    temp[i][j] = Math.max(0, board[i][j] - cntSea);
                }
                
            }
        }

        board = temp;
    }

}
