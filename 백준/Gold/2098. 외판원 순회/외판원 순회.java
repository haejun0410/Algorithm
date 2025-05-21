import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(tsp(0, 1)); // 시작점 0에서 시작, visited=1 (0번 도시 방문 처리)
    }

    static int tsp(int here, int visited) {
        // 모든 도시를 방문 (1111....1)
        if (visited == (1 << n) - 1) {
            if (board[here][0] != 0) return board[here][0];
            return Integer.MAX_VALUE / 2;
        }

        if (dp[here][visited] != -1) return dp[here][visited];

        dp[here][visited] = Integer.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            // 이미 방문했거나, 경로가 없으면 패스
            if ((visited & (1 << i)) != 0 || board[here][i] == 0) continue;
            
            // 기존 경로 vs 새 경로 중 짧은 거리 가져감. 
            dp[here][visited] = Math.min(
                dp[here][visited],
                tsp(i, visited | (1 << i)) + board[here][i]
            );
        }

        return dp[here][visited];
    }
}
