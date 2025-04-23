import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] scvs = new int[] {0, 0, 0};
        int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
        };

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][][] visited = new boolean[61][61][61];
        Queue<point> queue = new LinkedList<>();
        queue.offer(new point(scvs[0], scvs[1], scvs[2]));
        visited[scvs[0]][scvs[1]][scvs[2]] = true;

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                point cur = queue.poll();

                for (int[] atk : attack) {
                    int nx = Math.max(0, cur.x - atk[0]);
                    int ny = Math.max(0, cur.y - atk[1]);
                    int nz = Math.max(0, cur.z - atk[2]);

                    if (nx == 0 && ny == 0 && nz == 0) {
                        System.out.println(time);
                        return;
                    }

                    if (!visited[nx][ny][nz]) {
                        visited[nx][ny][nz] = true;
                        queue.offer(new point(nx, ny, nz));
                    }
                }
            }
        }
    }

    static class point {
        int x, y, z;
        point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
