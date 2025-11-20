import java.util.*;
import java.io.*;

public class Main{

    static char[][] board;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '*');
        }
        
        draw(0, 0, n);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            sb.append(board[i]).append('\n');
        }
        
        System.out.println(sb);


    }

    public static void draw(int y, int x, int size) {
        if (size == 1) return;

        int div = size / 3;

        for(int i = y + div; i < y + 2*div; i++) {
            for(int j = x + div; j < x + 2*div; j++) {
                board[i][j] = ' ';
            }
        }
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if (i == 1 && j == 1) continue;
                draw(y + i * div, x + j*div, div);
            }
        }
    }
}