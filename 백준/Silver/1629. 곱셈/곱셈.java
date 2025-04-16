import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b,c));
    }

    public static long pow(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        else {
            long tmp = pow(a, b/2, c);
            long answer = tmp * tmp % c;
            
            if (b % 2 == 1) {
                answer = (answer * a) % c;
            }

            return answer;
        }
    }
}
