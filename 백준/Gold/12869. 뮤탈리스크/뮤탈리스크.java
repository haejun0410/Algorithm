import java.io.*;
import java.util.*;

public class Main {

    static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {1, 3, 9},
            {1, 9, 3},
            {3, 1, 9},
            {3, 9, 1}

    };

    static int[] scvs = new int[] {0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][][] visited =new boolean[61][61][61];

        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {scvs[0], scvs[1], scvs[2]});

        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;

            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(int[] atk : attack) {
                    int nx = Math.max(0, curr[0] - atk[0]);
                    int ny = Math.max(0, curr[1] - atk[1]);
                    int nz = Math.max(0, curr[2] - atk[2]);

                    if (nx == 0 && ny == 0 && nz == 0) {
                        System.out.println(time);
                        return;
                    }

                    if (!visited[nx][ny][nz]) {
                        visited[nx][ny][nz] = true;
                        queue.offer(new int[] {nx, ny, nz});
                    }
                }
            }


        }
    }



}
