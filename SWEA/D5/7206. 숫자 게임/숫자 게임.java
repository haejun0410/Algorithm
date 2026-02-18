import java.io.*;

public class Solution {
    static int[] memo = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(testCase).append(" ").append(recursion(n)).append("\n");
        }
        System.out.print(sb);
    }

    static int recursion(int n) {
        if (n < 10) return 0;

        if (memo[n] > 0) return memo[n];

        String s = String.valueOf(n);
        int len = s.length();
        int maxStep = 0;

        for (int i = 1; i < (1 << (len - 1)); i++) {
            int mul = 1;
            int start = 0;

            for (int j = 0; j < len - 1; j++) {
                if ((i & (1 << j)) != 0) {
                    mul *= Integer.parseInt(s.substring(start, j + 1));
                    start = j + 1;
                }
            }
            mul *= Integer.parseInt(s.substring(start));

            maxStep = Math.max(maxStep, recursion(mul) + 1);
        }

        return memo[n] = maxStep;
    }
}