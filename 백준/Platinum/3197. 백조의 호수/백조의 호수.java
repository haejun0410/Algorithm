import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] lake;
    static boolean[][] visited;
    static Queue<int[]> swanQueue = new LinkedList<>();
    static Queue<int[]> nextSwanQueue = new LinkedList<>();
    static Queue<int[]> waterQueue = new LinkedList<>();
    static Queue<int[]> nextWaterQueue = new LinkedList<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[] swan1, swan2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new char[R][C];
        visited = new boolean[R][C];
        List<int[]> swans = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] != 'X') {
                    waterQueue.add(new int[] { i, j });
                }
                if (lake[i][j] == 'L') {
                    swans.add(new int[] { i, j });
                }
            }
        }

        swan1 = swans.get(0);
        swan2 = swans.get(1);
        swanQueue.add(swan1);
        visited[swan1[0]][swan1[1]] = true;

        int days = 0;
        while (true) {
            if (moveSwan()) {
                System.out.println(days);
                break;
            }
            meltIce();
            days++;
        }
    }

    static boolean moveSwan() {
        while (!swanQueue.isEmpty()) {
            int[] pos = swanQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (lake[nx][ny] == '.') {
                    swanQueue.add(new int[] { nx, ny });
                } else if (lake[nx][ny] == 'X') {
                    nextSwanQueue.add(new int[] { nx, ny });
                } else if (lake[nx][ny] == 'L') {
                    return true;
                }
            }
        }
        swanQueue = nextSwanQueue;
        nextSwanQueue = new LinkedList<>();
        return false;
    }

    static void meltIce() {
        int size = waterQueue.size();
        for (int i = 0; i < size; i++) {
            int[] pos = waterQueue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = pos[0] + dx[d];
                int ny = pos[1] + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    continue;
                }
                if (lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    nextWaterQueue.add(new int[] { nx, ny });
                }
            }
        }
        waterQueue = nextWaterQueue;
        nextWaterQueue = new LinkedList<>();
    }
}
