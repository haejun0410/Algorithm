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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] board = new int[n][n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = 0;

            // check row
            for(int i=0; i<n; i++) {
                int sum = 0;
                for(int j=0; j<n; j++) {
                    if (board[i][j] == 1) {
                        sum += 1;
                    }
                    else {
                        if (sum == k) answer++;
                        sum = 0;
                    }
                }
                if (sum == k) answer++;
            }

            // check col
            for(int i=0; i<n; i++) {
                int sum = 0;
                for(int j=0; j<n; j++) {
                    if (board[j][i] == 1) {
                        sum += 1;
                    }
                    else {
                        if (sum == k) answer++;
                        sum = 0;
                    }
                }
                if (sum == k) answer++;
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);

    }
}