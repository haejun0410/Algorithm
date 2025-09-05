import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperatures = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n+1];
        for(int i=1; i<n+1; i++) {
            prefix[i] = prefix[i-1] + temperatures[i-1];
        }

        int maxSum = Integer.MIN_VALUE;

        for(int i=k; i<=n; i++) {
            int sum = prefix[i] - prefix[i-k];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}