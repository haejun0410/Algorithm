import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static boolean[][] ladder;
    static int min = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladder = new boolean[h+2][n+2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            ladder[a][b] = true;
        }

        backtracking(0);

        System.out.println(min > 3 ? -1 : min);
    }

    public static boolean check() {
        for (int i = 1; i <= n; i++) {
            int pos = i;
            for (int j = 1; j <= h; j++) {
                if (ladder[j][pos]) pos++;
                else if (ladder[j][pos-1]) pos--;
            }
            if (pos != i) return false;
        }
        return true;
    }

    public static void backtracking(int count) {
        if (count >= min) return;
        if (check()) {
            min = count;
            return;
        }
        if (count == 3) return;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if (ladder[i][j] || ladder[i][j-1] || ladder[i][j+1]) continue;

                ladder[i][j] = true;
                backtracking(count + 1);
                ladder[i][j] = false;
            }
        }
    }
}
