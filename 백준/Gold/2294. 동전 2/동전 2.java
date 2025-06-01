import java.io.*;
import java.util.*;

public class Main {

    static Integer[] coins;
    static int n,k;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new Integer[n];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[10001];
        Arrays.fill(dp, 10001);

        dp[0] = 0;

        for(int i=0; i<n; i++) {
            for (int j= coins[i]; j<= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }

}
