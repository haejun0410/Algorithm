import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] nums = new boolean[123456*2+1];

        for (int i = 2; i * i <= 123456 * 2; i++) {
            if (!nums[i]) {
                for (int j = i * i; j <= 123456 * 2; j += i) {
                    nums[j] = true;
                }
            }
        }
        for(;;) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int count = 0;
            for(int i=n+1; i<= 2*n; i++) {
                if (!nums[i]) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }
}