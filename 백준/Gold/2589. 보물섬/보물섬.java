import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static char[][] board;

    static int length = Integer.MIN_VALUE;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(length - 1);
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {y, x});
        int[][] visited = new int[n][m];
        visited[y][x] = 1;


        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && board[ny][nx] == 'L' && visited[ny][nx] == 0) {
                    queue.offer(new int[] {ny, nx});
                    visited[ny][nx] = visited[curr[0]][curr[1]] + 1;
                    length = Math.max(length, visited[curr[0]][curr[1]] + 1);
                }
            }
        }

    }
}
