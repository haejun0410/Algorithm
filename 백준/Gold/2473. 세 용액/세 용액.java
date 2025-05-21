import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        long min = Long.MAX_VALUE;
        int ans1 = 0, ans2 = 0, ans3 = 0;

        for(int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                long sum = (long)nums[i] + nums[left] + nums[right];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ans1 = nums[i];
                    ans2 = nums[left];
                    ans3 = nums[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[] result = {ans1, ans2, ans3};
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
