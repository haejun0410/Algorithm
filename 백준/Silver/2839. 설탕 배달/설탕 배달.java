import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] sugar = {3, 5};

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < sugar.length; i++) {
            for (int j = sugar[i]; j <= n; j++) {
                if (dp[j - sugar[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - sugar[i]] + 1);
                }
            }
        }
        
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
