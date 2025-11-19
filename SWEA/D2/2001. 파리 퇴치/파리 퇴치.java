import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] pref = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    int val = Integer.parseInt(st.nextToken());
                    pref[i][j] = pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1] + val;
                }
            }

            int answer = Integer.MIN_VALUE;
                
            for (int i = m; i <= n; i++) {
                for (int j = m; j <= n; j++) {
                    int sum = pref[i][j] - pref[i - m][j] - pref[i][j - m] + pref[i - m][j - m];
                    if (sum > answer) answer = sum;
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
