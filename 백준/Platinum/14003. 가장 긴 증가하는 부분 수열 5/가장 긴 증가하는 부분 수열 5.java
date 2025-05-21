import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        int[] idx = new int[n];

        for (int i = 0; i < n; i++) {
            if (lis.isEmpty() || arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
                idx[i] = lis.size() - 1;
            } else {
                int pos = lower_bound(lis, arr[i]);
                lis.set(pos, arr[i]);
                idx[i] = pos;
            }
        }

        int size = lis.size();
        int[] res = new int[size];
        for (int i = n - 1; i >= 0; i--) {
            if (idx[i] == size - 1) {
                res[--size] = arr[i];
            }
        }

        System.out.println(res.length);
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int lower_bound(List<Integer> lis, int target) {
        int start = 0;
        int end = lis.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (lis.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
