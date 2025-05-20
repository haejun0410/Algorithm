import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        costs = new int[n];

        int sum = 0;
        for(int i=0; i<n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            sum += costs[i];
        }

        int start = 1;
        int end = sum;

        int answer = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int mid) {
        int cnt = 1;
        int current = mid;

        int idx = 0;

        while (idx < n) {
            if (costs[idx] > mid) return false;

            if (current < costs[idx]) {
                cnt++;
                if (cnt > m) return false;
                current = mid;
            }
            else {
                current -= costs[idx];
                idx++;
            }
        }

        if (cnt <= m) return true;
        else return false;
    }
}
