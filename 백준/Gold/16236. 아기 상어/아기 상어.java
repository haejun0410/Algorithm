import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0, totalTime = 0;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static class Point implements Comparable<Point> {
        int y, x, dist;

        Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.y != o.y) return this.y - o.y;
            return this.x - o.x;
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<Point> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[n][n];

            pq.add(new Point(sharkY, sharkX, 0));
            visited[sharkY][sharkX] = true;

            boolean ate = false;


            while (!pq.isEmpty()) {
                Point curr = pq.poll();

                if (map[curr.y][curr.x] != 0 && map[curr.y][curr.x] < sharkSize) {
                    map[curr.y][curr.x] = 0;
                    eatCount++;

                    if (eatCount == sharkSize) {
                        sharkSize++;
                        eatCount = 0;
                    }

                    
                    sharkY = curr.y;
                    sharkX = curr.x;
                    
                    totalTime += curr.dist;
                    ate = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = curr.y + dy[i];
                    int nx = curr.x + dx[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[ny][nx]) {
                        if (map[ny][nx] <= sharkSize) {
                            visited[ny][nx] = true;
                            pq.add(new Point(ny, nx, curr.dist + 1));
                        }
                    }
                }


            }
            if (!ate) break;
        }

        System.out.println(totalTime);
    }
}