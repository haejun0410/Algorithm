import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int maxSize = -1;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            board[y-1][x-1] = 1;
        }

        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxSize);
	}

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {y, x});
        visited[y][x] = true;

        int cnt = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            cnt++;

            for(int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (board[ny][nx] == 1 && !visited[ny][nx]) {
                        queue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        maxSize = Math.max(maxSize, cnt);
    }
}

