import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        boolean flag = true;

        int satisfaction = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            count++;
            int today = pq.poll();
            satisfaction = (satisfaction / 2) + today;
            today -= m;

            if (today > k) {
                pq.add(today);
            }

            sb.append(satisfaction).append("\n");
        }

        System.out.println(count);
        System.out.println(sb.toString());
    }
}
