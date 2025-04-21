import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] computers;
    static int[] hackedCount; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        computers = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            computers[c2].add(c1);
        }

        hackedCount = new int[n + 1];
        Arrays.fill(hackedCount, -1);

        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int count = bfs(i);
            if (count > max) {
                max = count;
                result.clear();
                result.add(i);
            } else if (count == max) {
                result.add(i);
            }
        }

        Collections.sort(result);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static int bfs(int start) {
        if (hackedCount[start] != -1) return hackedCount[start];

        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : computers[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        hackedCount[start] = count;
        return count;
    }
}
