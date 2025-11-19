import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(testCase).append(" ");
            if (n % 2 == 0) {
                sb.append(-(n/2)).append("\n");
            }
            else {
                sb.append((n+1)/2).append("\n");
            }

        }

        System.out.println(sb);
    }
}