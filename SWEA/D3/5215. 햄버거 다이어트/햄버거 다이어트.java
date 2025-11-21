import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] flavor = new int[n];
            int[] calory = new int[n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                flavor[i] = Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());
            }

            int maxScore = -1;

            for(int mask = 0; mask < (1 << n); mask++) {
                int sumFlav = 0;
                int sumCal = 0;

                for(int j=0; j<n; j++) {
                    if ((mask & (1 << j)) != 0) {
                        sumFlav += flavor[j];
                        sumCal += calory[j];
                    }
                }

                if (sumCal <= l) {
                    maxScore = Math.max(maxScore, sumFlav);
                }
            }

            sb.append("#").append(testCase).append(" ").append(maxScore).append("\n");
        }

        System.out.println(sb.toString());
    }
}
