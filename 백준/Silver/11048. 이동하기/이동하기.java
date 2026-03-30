import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {0, 1, 1};
    static int[] dx = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = board[i][j];
                    continue;
                }

                int prevMax = 0;
                if (j - 1 >= 0) prevMax = Math.max(prevMax, dp[i][j - 1]);
                if (i - 1 >= 0) prevMax = Math.max(prevMax, dp[i - 1][j]);
                if (i - 1 >= 0 && j - 1 >= 0) prevMax = Math.max(prevMax, dp[i - 1][j - 1]);

                dp[i][j] = prevMax + board[i][j];
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}