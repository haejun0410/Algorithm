import java.util.*;
import java.io.*;

class Solution
{
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
            String num = String.valueOf(i);

            int clap = 0;

            for(char ch : num.toCharArray()) {
                if (ch == '3' || ch == '6' || ch == '9') clap++;
            }

            if (clap > 0) {
                for(int j=0; j<clap; j++) {
                    sb.append("-");
                }
                sb.append(" ");
            }
            else {
                sb.append(i).append(" ");
            }
        }

        String answer = sb.toString();

        System.out.println(answer);
    }
}