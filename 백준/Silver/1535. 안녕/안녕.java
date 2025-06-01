import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] loss = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            loss[i] = Integer.parseInt(st.nextToken());
        }


        int[] gain = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            gain[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for(int i=0; i<n; i++) {
            for(int k=100; k>=loss[i]; k--) {
                dp[k] = Math.max(dp[k], dp[k - loss[i]] + gain[i]);
            }
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
