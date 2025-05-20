import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);
            int cnt = 0;
            for(int i=0; i<n; i++) {
                int current = a[i];

                int start = 0;
                int end = m-1;

                int max = -1;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if (b[mid] < current) {
                        max = Math.max(max, mid);
                        start = mid + 1;
                    }
                    else {
                        end = mid -1;
                    }
                }
                if (max != -1) {
                    cnt += (max + 1);
                }

            }

            System.out.println(cnt);
        }
    }
}
