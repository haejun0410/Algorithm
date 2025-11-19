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
            int n = Integer.parseInt(br.readLine());

            HashSet<Character> set = new HashSet<>();

            boolean flag = true;
            int index = 1;
            while (flag) {
                String number = String.valueOf(n * index);

                for(int i=0; i<number.length(); i++) {
                    set.add(number.charAt(i));
                }

                if (set.size() == 10) flag = false;
                else index++;

            }

            sb.append("#").append(testCase).append(" ").append(n*index).append("\n");
        }

        System.out.print(sb);
    }
}