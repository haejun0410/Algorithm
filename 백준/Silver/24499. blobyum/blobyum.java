import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] applepie = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            applepie[i] = Integer.parseInt(st.nextToken());
        }
        
        long[] prefix = new long[2 * n + 1];

        for(int i = 1; i <= 2 * n; i++) {
            prefix[i] = prefix[i - 1] + applepie[(i - 1) % n];
        }
        
        long maxSum = 0;
        for(int i = k; i < n + k; i++) {
            long currentSum = prefix[i] - prefix[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}