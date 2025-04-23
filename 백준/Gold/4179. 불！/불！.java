import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static Character[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        Queue<point> player = new LinkedList<>();
        Queue<point> fire = new LinkedList<>();
        map = new Character[r][c];

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    player.offer(new point(i, j));
                    visited[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fire.offer(new point(i, j));
                }
            }
        }

        int time = 0;

        while (!player.isEmpty()) {
            time++;
            
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                point f = fire.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = f.y + dy[d];
                    int nx = f.x + dx[d];

                    if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                        if (map[ny][nx] == '.' || map[ny][nx] == 'J') {
                            map[ny][nx] = 'F';
                            fire.offer(new point(ny, nx));
                        }
                    }
                }
            }

            int playerSize = player.size();
            for (int i = 0; i < playerSize; i++) {
                point p = player.poll();
                
                if (p.y == 0 || p.y == r - 1 || p.x == 0 || p.x == c - 1) {
                    System.out.println(time);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = p.y + dy[d];
                    int nx = p.x + dx[d];

                    if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                        if (map[ny][nx] == '.' && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            player.offer(new point(ny, nx));
                        }
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static class point {
        int y, x;
        public point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
