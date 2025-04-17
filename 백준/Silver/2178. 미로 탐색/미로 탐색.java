import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Character[][] map = new Character[n][m];
        int[][] dist = new int[n][m];

        for (int i=0; i<n; i++) {
            String arr = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = arr.charAt(j);
                dist[i][j] = -1;
            }
        }
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};

        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0,0));
        dist[0][0] = 0;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i=0; i<4; i++) {
                int nX = p.x + dx[i];
                int nY = p.y + dy[i];

                if (nX < 0 || nX >= m || nY < 0 || nY >=n) {
                    continue;
                }
                if(map[nY][nX] == '0' || dist[nY][nX] != -1) {
                    continue;
                }

                queue.offer(new Point(nY, nX));

                dist[nY][nX] = dist[p.y][p.x] + 1;
            }
        }

        System.out.println(dist[n-1][m-1] + 1);
        
    }

    public static  class Point {
        int x,y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
