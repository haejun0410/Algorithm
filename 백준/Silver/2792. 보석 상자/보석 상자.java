import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] jewels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        jewels = new int[m];
        
        int max = 0;
        for(int i=0; i<m; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }

        int start = 1;
        int end = max;

        int jealous = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (check(mid)) {
                jealous = Math.min(jealous, mid);
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }

        System.out.println(jealous);


    }

    public static boolean check(int num) {
        int cnt = 0;

        for(int i=0; i<m; i++) {
            cnt += (jewels[i] + num - 1) / num;
        }

        if (cnt <= n) {
            return true;
        }
        else {
            return false;
        }
    }

}