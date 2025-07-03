import java.io.*;
import java.util.*;

public class Main {

    static int blueCount = 0;
    static int whiteCount = 0;
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursion(0, 0, n);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
    public static void recursion(int y, int x, int len) {
        int cnt = 0;
        for(int i=y; i<y+len; i++) {
            for(int j=x; j<x+len; j++) {
                cnt += board[i][j];
            }
        }

        if (cnt == len*len) {
            blueCount ++;
        }
        else if (cnt == 0) {
            whiteCount ++;
        }
        else {
            recursion(y, x, len / 2);
            recursion(y + len/2, x, len / 2);
            recursion(y, x + len/2, len / 2);
            recursion(y + len/2, x + len/2, len / 2);

        }
    }
}