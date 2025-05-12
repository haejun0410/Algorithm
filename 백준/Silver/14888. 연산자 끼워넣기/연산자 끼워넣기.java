import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        backtracking(nums[0], plus, minus, mul, div, 1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void backtracking(int value, int plus, int minus, int mul, int div, int idx) {
        if (idx == n) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        if (plus != 0) {
            backtracking(value + nums[idx], plus -1, minus, mul, div, idx+1);
        }
        if (minus != 0) {
            backtracking(value - nums[idx], plus, minus -1, mul, div, idx+1);
        }
        if (mul != 0) {
            backtracking(value * nums[idx], plus, minus, mul-1, div, idx+1);
        }
        if (div != 0) {
            backtracking(value / nums[idx], plus, minus, mul, div-1, idx+1);
        }
    }
}
