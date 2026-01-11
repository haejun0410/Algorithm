import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());

        long temp = 0;

        int ten = 10;

        for(int i=1; i<=n; i++) {
            if (ten == i) {
                ten = ten * 10;
            }

            temp = (temp * ten + i) % k;

        }

        System.out.println(temp);
    }
}
