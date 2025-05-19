import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long[][] lines = new long[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Long.parseLong(st.nextToken()) + 1000000000;
            lines[i][1] = Long.parseLong(st.nextToken()) + 1000000000;
        }

        Arrays.sort(lines, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            }
            else return Long.compare(o1[0], o2[0]);
        });

        long length = (lines[0][1] - lines[0][0]);
        long idx = lines[0][1];

        for(int i=1; i<n; i++) {
            long end = lines[i][1];
            long start = lines[i][0];

            if (end <= idx) continue;

            if (start >= idx) {
                length += (end - start);
                idx = end;
            }
            else {
                length += (end - idx);
                idx = end;
            }
        }

        System.out.println(length);

    }
}