import java.io.*;
import java.util.*;

public class Main {
    static int N, H;
    static long[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int size = Math.abs(N-H)+1;
        board = new long[size][size];
        board[0][0] = 1;
        for(int i=1; i<size; i++){
            board[i][0] = 1;
            for(int j=1; j<i+1; j++){
                board[i][j] = board[i-1][j] + board[i][j-1];
            }
        }
        bw.write(board[size-1][size-1] + " ");
        bw.close();
    }
}