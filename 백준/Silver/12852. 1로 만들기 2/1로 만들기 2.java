import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[1000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
        trace(n);
    }

    public static void trace(int here) {
        if (here == 0) return;
        System.out.print(here + " ");

        if (here % 3 == 0 && dp[here] == dp[here / 3] + 1) {
            trace(here / 3);
        } else if (here % 2 == 0 && dp[here] == dp[here / 2] + 1) {
            trace(here / 2);
        } else {
            trace(here - 1);
        }
    }
}
