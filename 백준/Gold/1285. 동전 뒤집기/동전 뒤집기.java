import java.io.*;

public class Main {
 
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] board = new int[n];

        for(int i=0; i<n; i++) {
            String arr = br.readLine();
            int value = 0;
            int mul = 1;
            for(int j=0; j<n; j++) {
                if (arr.charAt(j) == 'T') {
                    value += mul;
                }
                mul *= 2;
            }
            board[i] = value;
        }
        
        // 가로열 뒤집기 시도
        int min = (int)Math.pow(2, n*2);
        for (int i=0; i < (1 << n); i++) {
            min = Math.min(min, reverseCol(board, i));
        }

        System.out.println(min);
        
    }

    public static int reverseCol(int[] board, int comb) {
        int[] tempboard = board.clone();
        int answer = 0;
        for(int j=0; j<n; j++) {
            if ((comb & (1 << j)) != 0) {
                tempboard[j] = ~tempboard[j];
            }
        }
        answer = reverseRow(tempboard);
        return answer;
    }

    public static int reverseRow(int[] board) {
        int[] tempboard = board.clone();
        int answer = 0;
        for(int j=0; j<n; j++) {
            int temp = 0;
            for(int i=0; i<n; i++) {
                if((tempboard[i] & (1 << j)) != 0) {
                    temp++;
                }
            }
            temp = Math.min(temp, n - temp);
            answer += temp;
        }
        return answer;
    }
}
