import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] lectures;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lectures = new int[n];

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }

        int answer = end;

        while(start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int capacity) {
        int count = 1;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            if (sum + lectures[i] > capacity) {
                count++;
                sum = lectures[i];
            } else {
                sum += lectures[i];
            }
        }

        return count <= m;
    }
}
