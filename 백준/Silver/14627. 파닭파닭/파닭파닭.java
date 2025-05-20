import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] greenOnions = new int[s];
        int max = 0;
        long sum = 0;
        for(int i=0; i<s; i++) {
            greenOnions[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, greenOnions[i]);
            sum += greenOnions[i];
        }

        long start = 1;
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;

            int cnt = 0;

            for(int i=0; i<s; i++) {
                cnt += greenOnions[i] / mid;
            }

            if (cnt < c) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        long answer = sum - (end * c);

        System.out.println(answer);
    }
}
