import java.util.*;
import java.io.*;

class Solution
{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];

            int index = 0;
            int y = 0; int x = 0;

            for(int number=1; number<= n*n; number++) {
                board[y][x] = number;

                int ny = y + dy[index];
                int nx = x + dx[index];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n || board[ny][nx] != 0) {
                    index = (index + 1) % 4;
                    ny = y + dy[index];
                    nx = x + dx[index];
                }

                y = ny;
                x = nx;
            }

            sb.append("#").append(testCase).append("\n");

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }

        }
        
        System.out.println(sb.toString());

    }
}