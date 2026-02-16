import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = read();
        int[] arr = new int[read() - l + 1];
        for (int x = read(), i = 0; i < arr.length; i++) arr[i] = l++ | x;

        bw.write(String.valueOf(mex(arr)));
        bw.flush();
    }

    private static int mex(int[] arr) {
        if (arr[0] != 0) return 0;
        for (int i = 1; i < arr.length; i++) if (arr[i] - arr[i - 1] > 1) return arr[i - 1] + 1;

        return arr[arr.length - 1] + 1;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}