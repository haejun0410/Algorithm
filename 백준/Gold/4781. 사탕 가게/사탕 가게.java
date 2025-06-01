import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            double moneyDouble = Double.parseDouble(st.nextToken());
            if (n == 0 && moneyDouble == 0.00) break;

            int money = (int)Math.round(moneyDouble * 100);

            int[] dp = new int[money + 1];
            int[] cal = new int[n];
            int[] price = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                cal[i] = Integer.parseInt(st.nextToken());
                double p = Double.parseDouble(st.nextToken());
                price[i] = (int)Math.round(p * 100);
            }

            for (int i = 0; i < n; i++) {
                for (int j = price[i]; j <= money; j++) {
                    dp[j] = Math.max(dp[j], dp[j - price[i]] + cal[i]);
                }
            }

            System.out.println(dp[money]);
        }
    }
}
