import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] board;
    static int n;
    static int[] population;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        population = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            population[i+1] = Integer.parseInt(st.nextToken());
        }

        board = new boolean[n+1][n+1];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++) {
                int end = Integer.parseInt(st.nextToken());
                board[i+1][end] = true;
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=1; i < ((1 << n)-1); i++) {
            answer = Math.min(answer, bfs(i));
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }

    public static int bfs(int combi) {
        boolean[] visited = new boolean[n+1];
    
        int startA = -1;
        for (int i = 0; i < n; i++) {
            if ((combi & (1 << i)) != 0) {
                startA = i + 1;
                break;
            }
        }
    
        int startB = -1;
        for (int i = 0; i < n; i++) {
            if ((combi & (1 << i)) == 0) {
                startB = i + 1;
                break;
            }
        }
    
        if (startA == -1 || startB == -1) return Integer.MAX_VALUE; // 한쪽 그룹이 비었으면 무효
    
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startA);
        visited[startA] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next = 1; next <= n; next++) {
                if (!visited[next] && board[now][next] && (combi & (1 << (next-1))) != 0) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    
        queue.offer(startB);
        visited[startB] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next = 1; next <= n; next++) {
                if (!visited[next] && board[now][next] && (combi & (1 << (next-1))) == 0) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return Integer.MAX_VALUE; // 방문 못 한 게 있으면 무효
        }
    
        int groupA = 0;
        int groupB = 0;
        for (int i = 0; i < n; i++) {
            if ((combi & (1 << i)) != 0) groupA += population[i+1];
            else groupB += population[i+1];
        }
    
        return Math.abs(groupA - groupB);
    }
    
}
