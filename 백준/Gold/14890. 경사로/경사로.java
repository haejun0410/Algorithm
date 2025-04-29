import java.io.*;
import java.util.*;

public class Main {

    static int n,l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] newBoard = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                newBoard[i][j] = board[j][i];
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            if (roadOK(board[i])) {
                answer++;
            }
            if (roadOK(newBoard[i])) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    public static boolean roadOK(int[] arr) {
        boolean answer = true;

        int cnt = 1;

        for(int i=1; i<n; i++) {
            if (arr[i] > arr[i-1]) {
                if (arr[i] - arr[i-1] > 1) {
                    return false;
                }
                if (cnt >= l) {
                    answer = true;
                    cnt = 1;
                }
                else {
                    return false;
                }
            }
            else if (arr[i] == arr[i-1]) {
                cnt++;
                if (!answer && cnt == l) {
                    answer = true;
                    cnt = 0;
                }
            }
            else if (arr[i] < arr[i-1]) {
                if (arr[i-1] - arr[i] > 1) {
                    return false;
                }
                if (!answer) {
                    return false;
                }
                answer = false;
                cnt = 1;
                if (cnt == l) {
                    answer = true;
                    cnt = 0;
                }
            }
        }
        return answer;
    }
    
}
