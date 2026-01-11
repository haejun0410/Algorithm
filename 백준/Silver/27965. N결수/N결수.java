import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        long temp = 0;

        for(int i=1; i<=n; i++) {
            int len = (String.valueOf(i)).length();
            int pow10 = 1;
            for (int j = 0; j < len; j++) {
                pow10 = (pow10 * 10) % k;
            }

            temp = (temp * pow10 + i) % k;

        }

        System.out.println(temp);
    }
}
