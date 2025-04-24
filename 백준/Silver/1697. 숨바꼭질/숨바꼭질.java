import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        
        int time = 0;
        for(;;) {
            time++;
            int size = queue.size();

            for (int i=0; i<size; i++) {
                int pos = queue.poll();

                int npos = pos * 2;
                if (npos == k) {
                    System.out.println(time);
                    return;
                }
                if (npos >= 0 && npos <=100000 && !visited[npos]) {
                    queue.offer(npos);
                    visited[npos] = true;
                }
                npos = pos -1;
                if (npos == k) {
                    System.out.println(time);
                    return;
                }
                if (npos >= 0 && npos <=100000 && !visited[npos]) {
                    queue.offer(npos);
                    visited[npos] = true;
                }

                npos = pos + 1;
                if (npos == k) {
                    System.out.println(time);
                    return;
                }
                if (npos >= 0 && npos <=100000 && !visited[npos]) {
                    queue.offer(npos);
                    visited[npos] = true;
                }
            }
        }

    }
}
