import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] price = new int[n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            
            long maxPrice = 0;
            long answer = 0;
            
            for(int i=n-1; i>=0; i--) {
                if (price[i] > maxPrice) {
                    maxPrice = price[i];
                }
                else {
                    answer += (maxPrice - price[i]);
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        
        System.out.println(sb.toString());

    }
}