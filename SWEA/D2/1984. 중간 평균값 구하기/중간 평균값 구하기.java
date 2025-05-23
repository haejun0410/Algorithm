import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int[] nums = new int[10];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nums);

            int sum = 0;
            for(int i=1; i<9; i++) {
                sum += nums[i];
            }

            System.out.printf("#%d %d\n", t, Math.round(sum/8.0));
	}
}
}