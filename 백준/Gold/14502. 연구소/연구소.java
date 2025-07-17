import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int maxCount = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wall(0);
        System.out.println(maxCount);

    }

    public static void wall(int cnt) {
        if (cnt == 3) {
            virus();
            return;
        }

        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    wall(cnt + 1);
                    board[i][j] = 0;
                }
            }
        }
    }


    public static void virus() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = board[i].clone();
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int ny = cur[0] + dy[k];
                int nx = cur[1] + dx[k];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (temp[ny][nx] == 0) {
                        temp[ny][nx] = 2;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) {
                    safe++;
                }
            }
        }

        maxCount = Math.max(maxCount, safe);
    }


}