import java.util.*;
import java.io.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dx = {0, -1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;
            char[][][] board = new char[l][r][c];
            int[][][] visited = new int[l][r][c];
            int startz = -1;
            int starty = -1;
            int startx = -1;

            int endz = -1;
            int endy = -1;
            int endx = -1;



            for (int idx = 0; idx < l; idx++) {
                for (int i = 0; i < r; i++) {
                    String line = br.readLine();
                    Arrays.fill(visited[idx][i], -1);
                    for (int j = 0; j < c; j++) {
                        board[idx][i][j] = line.charAt(j);
                        if (board[idx][i][j] == 'S') {
                            startz = idx;
                            starty = i;
                            startx = j;
                        }
                        else if (board[idx][i][j] == 'E') {
                            endz = idx;
                            endy = i;
                            endx = j;
                        }
                    }

                }
                String empty = br.readLine();

            }

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[] {startz, starty, startx});

            visited[startz][starty][startx] = 0;

            boolean flag = false;

            while(!queue.isEmpty() && !flag) {
                int[] current = queue.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];

                for(int i=0; i<6; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    int nz = z + dz[i];

                    if (ny >= 0 && ny < r && nx >= 0 && nx < c && nz >= 0 && nz < l) {
                        if (board[nz][ny][nx] != '#' && visited[nz][ny][nx] == -1) {
                            visited[nz][ny][nx] = visited[z][y][x] + 1;
                            if (board[nz][ny][nx] == 'E') {
                                flag = true;
                                break;
                            }
                            queue.offer(new int[]{nz, ny, nx});
                        }
                    }
                }

            }

            if (flag) {
                System.out.printf("Escaped in %d minute(s).\n", visited[endz][endy][endx]);
            }
            else {
                System.out.println("Trapped!");
            }


        }
    }
}