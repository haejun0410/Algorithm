import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static char[] operators;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String expr = br.readLine();

        int numLen = (N + 1) / 2;
        int opLen = N / 2;

        numbers = new int[numLen];
        operators = new char[opLen];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                numbers[i / 2] = expr.charAt(i) - '0';
            else
                operators[i / 2] = expr.charAt(i);
        }

        dfs(1, numbers[0]);
        System.out.println(max);
    }

    static void dfs(int idx, int result) {
        if (idx >= numbers.length) {
            max = Math.max(max, result);
            return;
        }

        int noBracket = calc(result, numbers[idx], operators[idx - 1]);
        dfs(idx + 1, noBracket);

        if (idx + 1 < numbers.length) {
            int bracket = calc(numbers[idx], numbers[idx + 1], operators[idx]);
            int withBracket = calc(result, bracket, operators[idx - 1]);
            dfs(idx + 2, withBracket);
        }
    }

    static int calc(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
}
