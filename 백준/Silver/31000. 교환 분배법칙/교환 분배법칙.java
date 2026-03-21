import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = read();
        cnt = (2 * n + 1) * (2 * n + 1);
        for (int i = -n; i < 0; i++) count(i);
        for (int i = 1; i <= n; i++) count(i);

        bw.write(String.valueOf(cnt));
        bw.flush();
    }

    private static void count(int i) {
        for (int j = -n; j <= n; j++) if (Math.abs(1 - i - j) <= n) cnt++;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}