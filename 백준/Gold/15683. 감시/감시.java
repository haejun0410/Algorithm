import java.io.*;
import java.util.*;

public class Main {

    static int[][][] cctv = new int[][][] {
        // 1번 cctv
        {{0}, {1}, {2}, {3}},
        // 2번 cctv
        {{1,3}, {0,2}},
        // 3번 cctv
        {{0,1}, {1,2}, {2,3}, {3,0}},
        // 4번 cctv
        {{0,1,3}, {0,1,2}, {1,2,3}, {2,3,0}},
        // 5번 cctv
        {{0,1,2,3}}

    };

    static int n,m;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        List<int[]> cctvs = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0 && board[i][j] < 6) {
                    cctvs.add(new int[] {i, j, board[i][j]});
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        ret = dfs(cctvs, 0, board);
        System.out.println(ret);

    }

    public static int dfs(List<int[]> cctvs, int idx, int[][] board) {
        if (idx == cctvs.size()) {
            return count(board);
        }

        int[] current = cctvs.get(idx);
        int y = current[0], x = current[1], type = current[2];
        int minArea = Integer.MAX_VALUE;

        for(int[] direction : cctv[type-1]) {
            int[][] copyBoard = new int[n][m];
            for(int i=0; i<n; i++) {
                copyBoard[i] = board[i].clone();
            }

            for(int dir : direction) {
                monitor(copyBoard, y, x, dir);
            }
            minArea = Math.min(minArea, dfs(cctvs, idx+1, copyBoard));
        }

        return minArea;

    }

    static void monitor(int[][] board, int y, int x, int dir) {
        while (true) {
            y += dy[dir];
            x += dx[dir];
            if (y < 0 || y >= n || x < 0 || x >= m || board[y][x] == 6) {
                break;
            }
            if (board[y][x] == 0) {
                board[y][x] = -1;
            }
        }
    }

    static int count(int[][] board) {
        int unmonitored = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    unmonitored++;
                }
            }
        }
        return unmonitored;
    }


}