import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    static char[][] board;
    static Queue<int[]> jihunQueue;
    static Queue<int[]> fireQueue;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static boolean[][] visited;

    static boolean escaped = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        jihunQueue = new ArrayDeque<>();
        fireQueue = new ArrayDeque<>();
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'J'){
                    jihunQueue.add(new int[]{i, j});
                    visited[i][j] = true;
                    if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                        escaped = true;
                    }
                }
                else if (board[i][j] == 'F'){
                    fireQueue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int time = 0;

        for(;;) {
            if (escaped) {
                System.out.println(time+1);
                break;
            }
            time++;
            moveFire();
            boolean isMoved = moveJihun();
            if (!isMoved) {
                System.out.println("IMPOSSIBLE");
                break;
            }

        }

    }

    public static void moveFire() {
        int fireQueueSize = fireQueue.size();

        for(int i=0; i<fireQueueSize; i++) {
            int[] curr = fireQueue.poll();

            for(int k=0; k<4; k++) {
                int ny = curr[0] + dy[k];
                int nx = curr[1] + dx[k];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                    if (board[ny][nx] == 'J' || board[ny][nx] == '.') {
                        fireQueue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }

    public static boolean moveJihun() {
        int jihunQueueSize = jihunQueue.size();

        int isMoved = 0;

        for(int i=0; i<jihunQueueSize; i++) {
            int[] curr = jihunQueue.poll();

            for(int k=0; k<4; k++) {
                int ny = curr[0] + dy[k];
                int nx = curr[1] + dx[k];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                    if (board[ny][nx] == '.') {
                        jihunQueue.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                        isMoved|=1;

                        if (ny == 0 || ny == n-1 || nx == 0 || nx == m-1) {
                            escaped = true;
                        }
                    }
                }
            }
        }

        if (isMoved == 1) {
            return true;
        }
        return false;
    }



}
