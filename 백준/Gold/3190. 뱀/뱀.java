import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static int time;
    static Deque<int[]> queue = new ArrayDeque<>();
    static int cy = 0, cx = 0;
    static int dir = 1;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            board[y][x] = 1; // 사과
        }

        int l = Integer.parseInt(br.readLine());

        board[0][0] = 2; // 뱀 시작 위치
        queue.addLast(new int[]{0, 0});

        Map<Integer, String> turns = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            turns.put(t, d);
        }

        time = 0;

        while (true) {
            time++;
            if (!move()) break;

            if (turns.containsKey(time)) {
                String turn = turns.get(time);
                if (turn.equals("L")) {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                } else if (turn.equals("D")) {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                }
            }
        }
    }

    public static boolean move() {
        int ny = cy + dy[dir];
        int nx = cx + dx[dir];

        if (ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 2) {
            System.out.println(time);
            return false;
        }

        if (board[ny][nx] == 1) { // 사과
            board[ny][nx] = 2;
            queue.addFirst(new int[]{ny, nx});
        } else { // 빈칸
            board[ny][nx] = 2;
            queue.addFirst(new int[]{ny, nx});
            int[] tail = queue.pollLast();
            board[tail[0]][tail[1]] = 0;
        }

        cy = ny;
        cx = nx;
        return true;
    }
}
