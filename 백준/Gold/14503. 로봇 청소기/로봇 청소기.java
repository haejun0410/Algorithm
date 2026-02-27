
import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] isCleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;

        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if (!isCleaned[y][x]) {
                isCleaned[y][x] = true;
                answer++;
            }

            int count = 0;
            for (int idx = 0; idx < 4; idx++) {
                int ny = y + dy[idx];
                int nx = x + dx[idx];

                if (inRange(y, x, n, m)) {
                    if (board[ny][nx] == 0 && !isCleaned[ny][nx]) {
                        count++;
                    }
                }
            }

            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if (count == 0) {
                int ny = y + dy[(dir + 2) % 4];
                int nx = x + dx[(dir + 2) % 4];
                if (inRange(ny, nx, n, m)) {
                    // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    if (board[ny][nx] == 1) {
                        break;
                    }
                    // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                    y = ny;
                    x = nx;
                } else {
                    break;
                }

            } // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                // 반시계 방향으로 90도 회전한다.
                dir = (dir + 4 - 1) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (inRange(ny, nx, n, m)) {
                    if (board[ny][nx] == 0 && !isCleaned[ny][nx]) {
                        y = ny;
                        x = nx;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean inRange(int y, int x, int n, int m) {
        return (y >= 0 && y < n && x >= 0 && x < m);
    }
}
