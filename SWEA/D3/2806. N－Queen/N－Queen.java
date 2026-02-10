import java.util.*;
import java.io.*;

public class Solution {

    static int[] board;
    static int n;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n];
            Arrays.fill(board, -1);
            count = 0;
            recursion(0);
            sb.append("#").append(testCase).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static void recursion(int idx) {
        if (idx == n) {
            count++;
        }

        for(int i = 0; i < n; i++) {
            if (isAvaiable(idx, i)) {
                board[idx] = i;
                recursion(idx+1);
                board[idx] = -1;
            }
        }
    }

    public static boolean isAvaiable(int idx, int pos) {
        for(int i = 0; i < n ; i++) {
            if (board[i] != -1) {
                if (board[i] == pos || (Math.abs(idx - i) == Math.abs(pos - board[i]))) return false;
            }
        }

        return true;
    }
}
