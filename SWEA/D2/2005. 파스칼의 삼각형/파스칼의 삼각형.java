import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());

            int[][] triangle = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        triangle[i][j] = 1;
                    } else {
                        triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                    }
                }
            }
            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    sb.append(triangle[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
