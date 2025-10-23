import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, -1);

        queue.offer(n);
        dist[n] = 0;

        boolean flag = true;
        int time = 0;
        int method = 0;

        while(flag) {
            int size = queue.size();
            time++;

            for(int i=0; i<size; i++) {
                int curr = queue.poll();

                for(int next : new int[] { curr * 2, curr - 1, curr + 1}) {
                    if (next >= 0 && next <= 100000) {
                        if (next == k) {
                            flag = false;
                            method++;
                        }

                        if (dist[next] == -1 || dist[next] == time) {
                            queue.offer(next);
                            dist[next] = time;
                        }
                    }
                }
            }
        }

        System.out.println(time);
        System.out.println(method);
    }
}