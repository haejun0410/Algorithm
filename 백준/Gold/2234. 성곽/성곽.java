import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int[][] visited;
    static int n, m;

    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};

    static int idx;
    static int maxRoom = -1;

    static HashMap<Integer, Integer> hash = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        int[][] newVisited = new int[n][m];

        int max = -1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m-1; j++) {
                if (visited[i][j] != visited[i][j+1]) {
                    int temp = hash.get(visited[i][j]) + hash.get(visited[i][j+1]);
                    max = Math.max(max, temp);
                }
            }
        }

        for (int j=0; j<m; j++) {
            for(int i=0; i<n-1; i++) {
                if (visited[i][j] != visited[i+1][j]) {
                    int temp = hash.get(visited[i][j]) + hash.get(visited[i+1][j]);
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(idx-1);
        System.out.println(maxRoom);
        System.out.println(max);
    }

    public static void bfs() {
        idx = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (visited[i][j] == 0) {
                    int count = 0;
                    visited[i][j] = idx;
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cy = current[0];
                        int cx = current[1];

                        for(int k=0; k<4; k++) {
                            if ((board[cy][cx] & (1 << k)) == 0) {
                                int ny = cy + dy[k];
                                int nx = cx + dx[k];

                                if (visited[ny][nx] == 0) {
                                    visited[ny][nx] = idx;
                                    count++;
                                    queue.offer(new int[] {ny, nx});
                                }
                            }
                        }
                    }
                    
                    hash.put(idx, count);
                    idx++;
                    maxRoom = Math.max(maxRoom, count);
                }
            }
        }

    }
    
}
