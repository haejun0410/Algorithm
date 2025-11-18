import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] board;

        for (int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            for(int i=0; i<n; i++) {
                String line = br.readLine();
                for(int j=0; j<n; j++) {
                    board[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }

            int sum = 0;
            int mid = n / 2;
            
            for(int i=0; i<n; i++) {
                int gap = Math.abs(mid - i);
                int start = gap;
                int end = n - gap;
                for(int j=start; j<end; j++) {
                    sum += board[i][j];
                }
            }
            
            sb.append('#').append(test_case).append(' ').append(sum).append('\n');
            
        }
        
        System.out.println(sb.toString());
    }
}