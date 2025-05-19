import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static int n,m,t;

    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int T=0; T<t; T++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int i=x-1; i<n; i+=x) {
                rotate(i, d, k);
            }

            checkAdjust();

            int cnt = 0;

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if (visited[i][j]) {
                        cnt++;
                        board[i][j] = 0;
                    }
                }
            }

            if (cnt == 0) {
                getAvgAndProcess();
            }
        }

        System.out.println(getSum());

    }

    public static void rotate(int idx, int d, int k) {

        int[] temp = new int[m];

        if (d == 0) {
            for (int i=0; i<m; i++) {
                temp[(i + k) % m] = board[idx][i];
            }    
        }
        else {
            for (int i=0; i<m; i++) {
                temp[(i - k + m) % m] = board[idx][i];
            }
        }

        board[idx] = temp;
    }

    public static void checkAdjust() {
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (board[i][j] != 0 && !visited[i][j]) {
                    int cnt = dfs(i, j);
                    if (cnt == 0) {
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static int dfs(int y, int x) {
        int cnt = 0;
        visited[y][x] = true;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = (x + dx[i] + m) % m;

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                if (board[y][x] == board[ny][nx]) {
                    cnt += dfs(ny, nx)+1;
                }
            } 
        }

        return cnt;
    }

    public static void getAvgAndProcess() {
        int sum = 0, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    sum += board[i][j];
                    count++;
                }
            }
        }
    
        if (count == 0) return; 
    
        double avg = (double) sum / count;
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) continue;
    
                if (board[i][j] > avg) board[i][j]--;
                else if (board[i][j] < avg) board[i][j]++;
            }
        }
    }
    

    public static int getSum() {
        return (int) Arrays.stream(board)
            .flatMapToInt(Arrays::stream)
            .sum();
    }
}