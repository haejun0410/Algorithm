import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    
    static boolean[] visited;

    static void dfs(int index) {
        visited[index] = true;
        while (!visited[arr[index]]) {
            dfs(arr[index]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        arr = new int[N + 1];
        int[] answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int max = 0;
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            dfs(i);
            for (int j = 1; j < N + 1; j++) {
                if (visited[j] == true)
                    cnt++;
            }
            answer[i] = cnt;
            cnt = 0;
        }
        int max_index = 0;
        for (int i = 1; i < N + 1; i++) {
            if (max < answer[i]) {
                max = answer[i];
                max_index = i;
            }
        }
        System.out.println(max_index);

    }
}