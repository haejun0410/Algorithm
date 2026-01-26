import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0; i<m; i++) {
            int idx = Integer.parseInt(br.readLine());
            arr[idx] = 1;
        }

        for(int i=0; i<k; i++) {
            int[] newArr = new int[n];
            for(int idx = 0; idx < n; idx++) {
                if (arr[idx] == 1) {
                    newArr[(idx + 1+ n) % n] ^= 1;
                    newArr[(idx - 1+ n) % n] ^= 1;
                }
            }
            arr = newArr;
        }

        int count = 0;
        for(int i=0; i<n; i++) {
            if (arr[i] == 1) count++;
        }

        System.out.println(count);

    }
}
