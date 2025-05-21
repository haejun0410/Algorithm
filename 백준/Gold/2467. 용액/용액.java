import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        while(start < end) {
            int sum = nums[start] + nums[end];
            int absSum = Math.abs(sum);

            if(absSum < min) {
                min = absSum;
                ans1 = nums[start];
                ans2 = nums[end];
            }

            if(sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
