import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long sum1 = 0L;
        long sum2 = 0L;

        for(int i=1; i<=n-1; i++) {
            sum1 += i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            sum2 += Long.parseLong(st.nextToken());
        }

        System.out.println(sum2 - sum1);
    }
}
