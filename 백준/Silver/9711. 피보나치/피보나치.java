import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    static BigInteger[] fiboMem = new BigInteger[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        precompute();

        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            BigInteger result = fiboMem[p].mod(BigInteger.valueOf(q));

            sb.append("Case #").append(testCase).append(": ").append(result).append("\n");
        }

        System.out.print(sb);
    }

    public static void precompute() {
        fiboMem[0] = BigInteger.ZERO;
        fiboMem[1] = BigInteger.ONE;
        for (int i = 2; i <= 10000; i++) {
            fiboMem[i] = fiboMem[i - 1].add(fiboMem[i - 2]);
        }
    }
}