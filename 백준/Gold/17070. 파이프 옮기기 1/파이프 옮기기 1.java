import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], -1);  // dp 초기화만 여기서 진행
            }
        }

        System.out.println(search(0, 1, 0));  // 시작은 (0,1) 가로 방향
    }

    public static int search(int y, int x, int dir) {
        // 기저 사례: 도착 지점
        if (y == n - 1 && x == n - 1) return 1;

        // 메모이제이션
        if (dp[y][x][dir] != -1) return dp[y][x][dir];

        dp[y][x][dir] = 0;

        // 가로 이동
        if (dir == 0 || dir == 2) {
            int nx = x + 1;
            if (nx < n && board[y][nx] == 0) {
                dp[y][x][dir] += search(y, nx, 0);
            }
        }

        // 세로 이동
        if (dir == 1 || dir == 2) {
            int ny = y + 1;
            if (ny < n && board[ny][x] == 0) {
                dp[y][x][dir] += search(ny, x, 1);
            }
        }

        // 대각선 이동
        int ny = y + 1;
        int nx = x + 1;
        if (ny < n && nx < n && board[y][nx] == 0 && board[ny][x] == 0 && board[ny][nx] == 0) {
            dp[y][x][dir] += search(ny, nx, 2);
        }

        return dp[y][x][dir];
    }
}
