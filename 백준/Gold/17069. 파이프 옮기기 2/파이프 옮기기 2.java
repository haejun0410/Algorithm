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
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(search(0, 1, 0));

    }

    // dir -> 0 : 가로 , 1 : 세로, 2 : 대각선
    public static long search(int y, int x, int dir) {
        if (y == n-1 && x == n-1) return 1;

        if (dp[y][x][dir] != -1) return dp[y][x][dir];

        dp[y][x][dir] = 0;


        int ny, nx;
        // 가로 이동 (현재 방향이 가로, 대각일 때만 가능)
        if (dir == 0 || dir == 2) {
            ny = y;
            nx = x + 1;

            if (ny < n && nx < n) {
                if (board[ny][nx] == '0') {
                    dp[y][x][dir] += search(ny, nx, 0);
                }
            }
        }
        // 세로 이동 (현재 방향이 세로, 대각일 때만 가능)
        if (dir == 1 || dir == 2) {
            ny = y + 1;
            nx = x;
            if (ny < n && nx < n) {
                if (board[ny][nx] == '0') {
                    dp[y][x][dir] += search(ny, nx, 1);
                }
            }
        }
        // 대각선 이동 (모든 경우에 대해 가능)
        ny = y + 1;
        nx = x + 1;
        if (ny < n && nx < n) {
            if (board[y][nx] == '0' && board[ny][x] == '0' && board[ny][nx] == '0') {
                dp[y][x][dir] += search(ny, nx, 2);
            }
        }

        return dp[y][x][dir];
    }
}