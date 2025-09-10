import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] board = new int[h][w];

        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                if (line.charAt(j) == 'c') {
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = -1;
                }
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=1; j<w; j++) {
                if(board[i][j-1] != -1 && board[i][j] == -1) {
                    board[i][j] = board[i][j-1] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
