import java.io.*;
import java.util.*;

public class Main {

    static long[] prefix;
    static int n,s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        long[] nums = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        prefix = new long[n];

        prefix[0] = nums[0];

        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int start = 1;
        int end = n;
        int minValue = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                minValue = Math.min(minValue, mid);
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        if (minValue == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(minValue);
        }


    }

    public static boolean check(int len) {
        for (int i = 0; i <= n - len; i++) {
            long sum;
            if (i == 0) {
                sum = prefix[i + len - 1];
            } else {
                sum = prefix[i + len - 1] - prefix[i - 1];
            }
    
            if (sum >= s) {
                return true;
            }
        }
        return false;
    }
}