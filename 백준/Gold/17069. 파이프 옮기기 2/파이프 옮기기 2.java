import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static char[][] board;
    static long[][][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        dp = new long[n][n][3];

        // 보드 입력 받기
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j*2);
            }
        }

        dp[0][1][0] = 1;
        System.out.println(search());

    }

    public static long search() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1<n && board[i][j+1]!='1') {
                    dp[i][j+1][0] += dp[i][j][0];
                    dp[i][j+1][0] += dp[i][j][2];
                }
                // 세로 DP 갱신
                if (i+1<n && board[i+1][j]!='1') {
                    dp[i+1][j][1] += dp[i][j][1];
                    dp[i+1][j][1] += dp[i][j][2];
                }
                // 대각 DP 갱신
                if (j+1<n && i+1<n && board[i][j+1]!='1' && board[i+1][j]!='1' && board[i+1][j+1]!='1') {
                    dp[i+1][j+1][2] += dp[i][j][0];
                    dp[i+1][j+1][2]+= dp[i][j][1];
                    dp[i+1][j+1][2] += dp[i][j][2];
                }
            }
        }

        return dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
    }
}