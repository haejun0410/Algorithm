import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] visited = new int[101];
        int[] snake = new int[101];

        for (int i=1; i<101; i++) {
            snake[i] = i;
        }
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake[start] = end;
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake[start] = end;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()) {
            int pos = queue.poll();

            for (int i=1; i<=6; i++) {
                int npos = snake[pos + i];
                if (npos <= 100 && visited[npos] == 0) {
                    visited[npos] = visited[pos] + 1;

                    if (npos == 100) {
                        System.out.println(visited[100]);
                        return;
                    }
                    else {
                        queue.offer(npos);
                    }
                }

            }
        }
    }
}
