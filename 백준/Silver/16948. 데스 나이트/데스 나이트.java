import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][n];

        queue.offer(new int[] {r1, c1});
        visited[r1][c1] = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i=0; i<6; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && visited[ny][nx] == 0) {
                    queue.offer(new int[] {ny, nx});
                    visited[ny][nx] = visited[current[0]][current[1]] + 1;

                    if (ny == r2 && nx == c2) {
                        System.out.println(visited[r2][c2] -1);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);

    }
}

