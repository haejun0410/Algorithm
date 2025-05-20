import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = (int)((long) y * 100 / x);

        int start = 1;
        int end = 1000000000;
        int answer = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int newZ = (int)((long)(y + mid) * 100 / (x + mid));

            if (newZ > z) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
