import java.io.*;
import java.util.*;

public class Main {

    static int t,w;
    static int[] trees;
    static int[][][] dp;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        trees = new int[t];

        for(int i=0; i<t; i++) {
            trees[i] = Integer.parseInt(br.readLine()) - 1;
        }

        dp = new int[1001][2][31];
        for(int i=0; i<1001; i++) {
            for(int j=0; j<2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(Math.max(search(0, 0, w), search(0, 1, w-1)));
    }

    public static int search(int time, int index, int count) {
        if (count < 0) {
            return Integer.MIN_VALUE;
        }

        if (time == t) {
            return 0;
        }

        if (dp[time][index][count] != -1) {
            return dp[time][index][count];
        }

        dp[time][index][count] = Math.max(search(time + 1, index^1, count -1), search(time + 1, index, count));
        if (trees[time] == index) {
            dp[time][index][count]++;
        }

        return dp[time][index][count];
    }
	
}
