import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int min = 256;
        int max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] < min) min = board[i][j];
                if (board[i][j] > max) max = board[i][j];
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;
        
        for (int h = min; h <= max; h++) {
            int inventory = b;
            int time = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = board[i][j] - h;
                    if (diff > 0) {
                        time += Math.abs(diff) * 2;
                        inventory += Math.abs(diff);
                    } else if (diff < 0) {
                        time += Math.abs(diff);
                        inventory -= Math.abs(diff);
                    }
                }
            }
            
            if (inventory >= 0) {
                if (time <= answerTime) {
                    answerTime = time;
                    answerHeight = h;
                }
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}