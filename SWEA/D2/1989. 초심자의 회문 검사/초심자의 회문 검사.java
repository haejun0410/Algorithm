import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            String word = br.readLine();

            StringBuilder reversed = new StringBuilder(word).reverse();

            sb.append('#').append(testCase).append(" ")
                    .append(word.equals(reversed.toString()) ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }
}