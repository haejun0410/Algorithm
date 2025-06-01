import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(;;) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            dp = new long[1000][1000];
            for(int i=0; i<1000; i++) {
                Arrays.fill(dp[i], -1);
            }
            System.out.println(search(n, 0));
        }
    }

    public static long search(int whole, int half) {
        if (whole == 0 && half == 0) return 1;

        if (dp[whole][half] != -1) {
            return dp[whole][half];
        }

        dp[whole][half] = 0;
        if (whole > 0) {
            dp[whole][half] += search(whole -1, half + 1);
        }
        if (half > 0) {
            dp[whole][half] += search(whole, half -1);
        }

        return dp[whole][half];
    }
	
}
