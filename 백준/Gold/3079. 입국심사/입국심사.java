// 3079

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] times = new long[n];
        long max = -1;
        for(int i=0; i<n; i++) {
            times[i] = Long.parseLong(br.readLine());
            max = Math.max(max, times[i]);
        }
        Arrays.sort(times);
        long min = times[0];

        // 심사 소요시간 최소 : m 최대 : max(times) * m;
        long start = 0;
        long end = m * max;

        long answer = Long.MAX_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            //System.out.println(start + " " + end + " " + mid);

            long rest = m;

            boolean flag = false;

            for(int i=0; i<n; i++) {
                rest -= mid / times[i];
                if (rest <= 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                //System.out.println(mid + " " + rest);
                end = mid -1;
                answer = Math.min(answer, mid);
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}