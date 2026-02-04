import java.util.*;
import java.io.*;

public class Main {

    static int[] dy =   {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx =   {0, -1, 0, 1, 1, -1, 1, -1};
    static int[] fuels = {1, 1, 1, 0, 0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] board = new char[h][w];
        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;

        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'K') {
                    startY = i;
                    startX = j;
                }
                else if (board[i][j] == '*') {
                    endY = i;
                    endX = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {startY, startX, 0});
        int[][] visited = new int[h][w];
        for(int i=0; i<h; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int y = curr[0];
            int x = curr[1];
            int fuel = curr[2];

            for(int i=0; i<8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 & ny < h && nx >= 0 && nx < w && board[ny][nx] != '#') {
                    int nextFuel = fuel + fuels[i];
                    if (nextFuel < visited[ny][nx]) {
                        visited[ny][nx] = nextFuel;
                        queue.offer(new int[] {ny, nx, nextFuel});
                    }
                }
            }
        }

        System.out.println(visited[endY][endX] == Integer.MAX_VALUE? -1 : visited[endY][endX]);

    }
}