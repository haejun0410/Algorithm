import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y<=y2-1; y++) {
                for (int x=x1; x<=x2-1; x++) {
                    map[y][x]++;
                }
            }
        }

        visited = new boolean[n][m];

        int count = 0;
        List<Integer> sizes = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    count++;
                    int size = dfs(i, j);
                    sizes.add(size);
                }
            }
        }

        System.out.println(count);
        Collections.sort(sizes);

        for (int size : sizes) {
            System.out.print(size + " ");
        }
    }

    public static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;

        for (int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if (map[ny][nx] == 0 && !visited[ny][nx]) {
                    count += dfs(ny, nx);
                }
            }
        }

        return count;
    }
}
