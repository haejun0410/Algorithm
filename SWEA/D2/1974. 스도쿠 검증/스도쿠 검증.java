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

            int[][] board = new int[9][9];
            for(int i=0; i<9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean flag = true;

            // check row & col
            for (int i = 0; i < 9; i++) {
                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0; j < 9; j++) {
                    sum1 += board[i][j];
                    sum2 += board[j][i];
                }
                if (sum1 != 45 || sum2 != 45) {
                    flag = false;
                    break;
                }
            }

            // check square
            if (flag) {
                for(int sr = 0; sr < 9; sr+=3) {
                    for(int sc = 0; sc < 9; sc+=3) {
                        int sum = 0;
                        for(int i=sr; i<sr + 3; i++) {
                            for(int j=sc; j<sc + 3; j++) {
                                sum += board[i][j];
                            }
                        }
                        if (sum != 45) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
            }

            sb.append("#").append(testCase).append(" ")
                    .append(flag ? 1 : 0).append("\n");
        }

        System.out.println(sb);
    }
}