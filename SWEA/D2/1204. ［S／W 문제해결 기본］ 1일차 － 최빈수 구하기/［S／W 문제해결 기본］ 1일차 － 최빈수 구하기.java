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
            int test_num = Integer.parseInt(br.readLine());
            int[] scoreCount = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<1000; i++) {
                int score = Integer.parseInt(st.nextToken());
                scoreCount[score]++;
            }

            int count = 0;
            int answer = 0;

            for(int i=0; i<=100; i++) {
                if (scoreCount[i] >= count) {
                    answer = i;
                    count = scoreCount[i];
                }
            }

            sb.append("#").append(test_num).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}