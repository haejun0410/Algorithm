class Solution {
    
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static final int MOD =1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddle = new boolean[n][m];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]-1][puddle[0]-1] = true;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    
                    if (ny >= n || nx >= m) continue;
                    
                    if (!isPuddle[ny][nx]) {
                        dp[ny][nx] = (dp[ny][nx] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}