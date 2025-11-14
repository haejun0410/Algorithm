import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] board;
    static boolean[][] planted;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        planted = new boolean[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0);

        System.out.println(answer);
    }

    public static void backtracking(int count) {
        if (count == 3) {
            answer = Math.min(answer, calculate());
            return;
        }

        for(int i=1; i<n-1; i++) {
            for(int j=1; j<n-1; j++) {
                if (!planted[i][j]) {
                    if (!planted[i-1][j] && !planted[i][j-1] && !planted[i+1][j] && !planted[i][j+1]) {
                        planted[i][j] = true; planted[i-1][j] = true; planted[i][j-1] = true; planted[i+1][j] = true; planted[i][j+1] = true;
                        backtracking(count + 1);
                        planted[i][j] = false; planted[i-1][j] = false; planted[i][j-1] = false; planted[i+1][j] = false; planted[i][j+1] = false;
                    }
                }
            }
        }
    }

    public static int calculate() {
        int sum = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (planted[i][j]) {
                    sum += board[i][j];
                }
            }
        }

        return sum;
    }

}
