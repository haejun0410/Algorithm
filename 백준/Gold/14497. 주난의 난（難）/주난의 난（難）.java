import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;

        board = new char[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        boolean flag = true;
        int count = 0;
        while(flag) {
            count++;
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][m];
            ArrayList<int[]> temp = new ArrayList<>();

            queue.offer(new int[] {y1, x1});
            visited[y1][x1] = true;

            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (board[curr[0]][curr[1]] == '#') {
                    flag = false;
                    break;
                }
                else if (board[curr[0]][curr[1]] != '1') {
                    for(int i=0; i<4; i++) {
                        int ny = curr[0] + dy[i];
                        int nx = curr[1] + dx[i];
                        if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                            queue.offer(new int[] {ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
                else if (board[curr[0]][curr[1]] == '1') {
                    temp.add(new int[] {curr[0], curr[1]});
                }
            }

            for(int[] wall : temp) {
                board[wall[0]][wall[1]] = '0';
            }
        }

        System.out.println(count);
    }
}
