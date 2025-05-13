import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<List<Integer>> adj;
    static List<List<Integer>> revadj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        revadj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            revadj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            adj.get(from).add(to);
            revadj.get(to).add(from);
        }

        
        int answer = 0;

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            int totalcnt = dfs(i);
            totalcnt += revdfs(i);

            if (totalcnt == n-1) {
                answer++;
            }
        }

        System.out.println(answer);
        
    }

    public static int dfs(int start) {

        int cnt = 0;

        for (int next : adj.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                cnt += 1 + dfs(next);
            }
        }

        return cnt;
    }
    public static int revdfs(int start) {

        int cnt = 0;

        for (int next : revadj.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                cnt += 1 + revdfs(next);
            }
        }

        return cnt;
    }
}
