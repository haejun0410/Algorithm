import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n+1];
        for(int i=0; i<n; i++) {
            prefix[i+1] = Math.max(prefix[i] + arr[i], arr[i]);
        }

        int ret = Arrays.stream(Arrays.copyOfRange(prefix, 1, prefix.length)).max().getAsInt();

        System.out.println(ret);
    }
}