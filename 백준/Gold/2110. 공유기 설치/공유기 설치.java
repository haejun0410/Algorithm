import java.io.*;
import java.util.*;

class Main {

    static int[] arr;
    static int n,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 1;
        int end = arr[n-1] - arr[0];
        int answer = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            int count = count(mid);

            if (count >= c) {
                answer = mid;
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }

        System.out.println(answer);
    }

    public static int count(int distance) {
        int count = 1;
        int last = arr[0];

        for(int i=1; i<n; i++) {
            if (arr[i] - last >= distance) {
                count++;
                last = arr[i];
            }
        }

        return count;
    }
}
