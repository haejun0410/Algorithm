import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static int[][] rotates;
    static int n,m,k;
    static int minVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n : 보드의 세로 길이
        n = Integer.parseInt(st.nextToken());
        // m : 보드의 가로 길이
        m = Integer.parseInt(st.nextToken());
        // k : 회전 연산의 수
        k = Integer.parseInt(st.nextToken());

        // n x m 보드 입력
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 : r, 1 : c, 2 : s
        rotates = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new  StringTokenizer(br.readLine(), " ");
            rotates[i][0] = Integer.parseInt(st.nextToken()) - 1;
            rotates[i][1] = Integer.parseInt(st.nextToken()) - 1;
            rotates[i][2] = Integer.parseInt(st.nextToken());
        }

        minVal = Integer.MAX_VALUE;

        permutation(0, new int[k], new boolean[k]);

        System.out.println(minVal);

    }

    // 회전의 경우의 수 순열 (순서 중요)
    public static void permutation(int idx, int[] arr, boolean[] visited) {
        if (idx == k) {
            simulate(arr);
            return;
        }

        for (int i = 0; i < k; i++) {
            // 이미 선택한 수라면 패스
            if (visited[i]) continue;
            // 다음 idx 선택하러
            visited[i] = true;
            arr[idx] = i;
            permutation(idx + 1, arr, visited);
            visited[i] = false;
        }

    }

    public static void simulate(int[] arr) {
        int[][] temp = copyMap();

        for(int idx = 0; idx < k; idx++) {
            int r = rotates[arr[idx]][0];
            int c = rotates[arr[idx]][1];
            int S = rotates[arr[idx]][2];

            for (int s = 1; s <= S; s++) {
                // 위
                int upTmp = temp[r-s][c+s];
                for (int x = c + s; x > c-s; x--) {
                    temp[r-s][x] = temp[r-s][x-1];
                }

                // 오른쪽
                int rightTmp = temp[r+s][c+s];
                for (int y = r+s; y > r-s; y--) {
                    temp[y][c+s] = temp[y-1][c+s];
                }
                temp[r-s+1][c+s] = upTmp;
                // 아래
                int downTmp = temp[r+s][c-s];
                for (int x = c-s; x < c+s; x++) {
                    temp[r+s][x] = temp[r+s][x+1];
                }
                temp[r+s][c+s-1] = rightTmp;

                // 왼쪽
                for (int y = r-s; y < r+s; y++) {
                    temp[y][c-s] = temp[y+1][c-s];
                }

                temp[r+s-1][c-s] = downTmp;
            }
        }

        calculate(temp);
    }

    public static int[][] copyMap() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        return tmp;
    }

    public static void calculate(int[][] arr) {

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += arr[i][j];
            }

            minVal = Math.min(minVal, temp);
        }


    }
}