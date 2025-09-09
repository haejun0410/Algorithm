import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = start + m-1;

        int appleNum = Integer.parseInt(br.readLine());
        int distance = 0;

        for(int i=0; i<appleNum; i++){
            int pos = Integer.parseInt(br.readLine());
            if (pos < start) {
                int diff = Math.abs(start - pos);
                distance += diff;
                start -= diff;
                end -= diff;
            }
            else if (pos > end) {
                int diff = Math.abs(pos - end);
                distance += diff;
                end += diff;
                start += diff;
            }
        }

        System.out.println(distance);
    }
}
