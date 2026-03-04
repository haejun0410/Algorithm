import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, 0});
        visited[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int dist = curr[2];

            if (dist > visited[y][x]) continue;

            if (y == n - 1 && x == m - 1) break;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    int cost = board[ny][nx] - '0';
                    if (visited[ny][nx] > dist + cost) {
                        visited[ny][nx] = dist + cost;
                        if (cost == 0) {
                            queue.addFirst(new int[] {ny, nx, visited[ny][nx]});
                        }
                        else {
                            queue.addLast(new int[] {ny, nx, visited[ny][nx]});
                        }
                    }
                }
            }
        }

        System.out.println(visited[n - 1][m - 1]);
    }
}