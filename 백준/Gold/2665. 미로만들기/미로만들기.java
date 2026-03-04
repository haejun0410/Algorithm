import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});
        visited[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int dist = curr[2];

            if (visited[curr[0]][curr[1]] < dist) continue;

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                    int cost = (board[ny].charAt(nx) - '0')^1;
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

        System.out.println(visited[n-1][n-1]);
    }
}