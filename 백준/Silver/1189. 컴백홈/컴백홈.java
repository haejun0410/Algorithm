import java.io.*;
import java.util.*;

public class Main {

    static Character[][] board;
    static int r,c,k;
    static int count = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new Character[r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++) {
            String arr = br.readLine();
            for(int j=0; j<c; j++) {
                board[i][j] = arr.charAt(j);
            }
        }
        visited[r-1][0] = true;
        dfs(r-1, 0, 1);

        System.out.println(count);
    }

    public static void dfs(int y, int x, int length) {
        if (length == k){
            if (y == 0 && x == c-1) {
                count++;
            }
            return;
        }

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                if (board[ny][nx] != 'T' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx, length+1);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
