import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=Math.min(a,b); i++) {
            if (a % i == 0 && b % i == 0) {
                sb.append(i).append(" ").append(a/i).append(" ").append(b/i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
