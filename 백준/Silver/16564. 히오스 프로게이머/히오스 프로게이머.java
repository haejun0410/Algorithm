import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] levels = new long[n];
        long min = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            levels[i] = Long.parseLong(br.readLine());
            min = Math.min(min, levels[i]);
        }

        Arrays.sort(levels);

        long start = min;
        long end = min + k;
        long ans = 0;

        while (start <= end) {
            long levelUp = k;
            long mid = (start + end) / 2;

            for(long level : levels) {
                if (level < mid) {
                    levelUp -= (mid - level);
                }
            }

            if (levelUp < 0) {
                end = mid-1;
            }
            else {
                ans = mid;
                start = mid + 1;
            }
        }

        System.out.println(ans);


        
    }
}
