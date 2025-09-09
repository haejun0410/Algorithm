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
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n+1][m+1];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            board[y1][x1]++;
            board[y1][x2]--;
            board[y2][x1]--;
            board[y2][x2]++;

        }

        for(int i=0; i<n; i++) {
            for(int j=1; j<m; j++) {
                board[i][j] += board[i][j-1];
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                board[i][j] += board[i-1][j];
            }
        }

        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        ArrayList<Integer> areaList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                    cnt++;
                    int area = 0;
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        area++;
                        for(int idx=0; idx<4; idx++) {
                            int ny = curr[0] + dy[idx];
                            int nx = curr[1] + dx[idx];

                            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && board[ny][nx] == 0) {
                                visited[ny][nx] = true;
                                queue.offer(new int[] {ny, nx});
                            }
                        }
                    }
                    areaList.add(area);

                }
            }
        }

        Collections.sort(areaList);
        System.out.println(cnt);
        for(Integer area : areaList) {
            System.out.print(area + " ");
        }
    }
}
