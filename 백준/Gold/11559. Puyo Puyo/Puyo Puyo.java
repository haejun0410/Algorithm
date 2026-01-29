import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[12][6];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int totalChains = 0;

        while (true) {
            if (puyo()) {
                totalChains++;
                down();
            } else {
                break;
            }
        }

        System.out.println(totalChains);
    }

    public static boolean puyo() {
        boolean exploded = false;
        boolean[][] visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.' && !visited[i][j]) {
                    if (bfs(i, j, visited)) {
                        exploded = true;
                    }
                }
            }
        }
        return exploded;
    }

    public static boolean bfs(int y, int x, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        char color = board[y][x];
        queue.offer(new int[]{y, x});
        list.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int k = 0; k < 4; k++) {
                int ny = curr[0] + dy[k];
                int nx = curr[1] + dx[k];

                if (ny >= 0 && ny < 12 && nx >= 0 && nx < 6) {
                    if (!visited[ny][nx] && board[ny][nx] == color) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        list.add(new int[]{ny, nx});
                    }
                }
            }
        }

        if (list.size() >= 4) {
            for (int[] pos : list) {
                board[pos[0]][pos[1]] = '.';
            }
            return true;
        }
        return false;
    }

    public static void down() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i > 0; i--) {
                if (board[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] != '.') {
                            board[i][j] = board[k][j];
                            board[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}