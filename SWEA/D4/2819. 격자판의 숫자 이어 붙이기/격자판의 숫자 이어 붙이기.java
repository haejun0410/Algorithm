import java.util.*;
import java.io.*;

public class Solution {
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= TC; testCase++){
            board = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            set = new HashSet<>();
            
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, 0, String.valueOf(board[i][j]));
                }
            }

            sb.append("#").append(testCase).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, int depth, String num) {
        if (depth == 6) {
            set.add(num);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
                dfs(nr, nc, depth + 1, num + board[nr][nc]);
            }
        }
    }
}