import java.util.*;
import java.io.*;

public class Solution {

    static char[][] board;
    static int[] dy = {-1, 0, 1, 0, 1, 1, -1, -1};
    static int[] dx = {0, -1, 0, 1, 1, -1, 1, -1};
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            n = Integer.parseInt(br.readLine());
            board = new char[n][n];
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            boolean[][] visited = new boolean[n][n];
            Queue<int[]> queue = new ArrayDeque<>();
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.' && !visited[i][j] && check(i, j) == 0) {
                        answer++;
                        queue.offer(new int[] {i, j});
                        visited[i][j] = true;

                        while(!queue.isEmpty()) {
                            int[] curr = queue.poll();
                            for (int idx = 0; idx < 8; idx++) {
                                int ny = curr[0] + dy[idx];
                                int nx = curr[1] + dx[idx];

                                if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx]) {
                                    int click = check(ny, nx);

                                    if (click == 0) {
                                        visited[ny][nx] = true;
                                        queue.offer(new int[] {ny, nx});
                                    }
                                    else {
                                        visited[ny][nx] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '.' && !visited[i][j]) answer++;
                }
            }
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static int check(int y, int x) {
        int count = 0;

        for (int idx = 0; idx < 8; idx++) {
            int ny = y + dy[idx];
            int nx = x + dx[idx];

            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                if (board[ny][nx] == '*') {
                    count++;
                }
            }
        }

        return count;
    }
}
