import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] map = new int[r][c];
        int airIdx = -1;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && airIdx == -1) {
                    airIdx = i;
                }
            }
        }

        int upperIdx = airIdx;
        int downIdx = airIdx + 1;

        for (int time = 0; time < t; time++) {
            int[][] spread = new int[r][c];

            // 미세먼지 확산
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) {
                        int spreadAmount = map[i][j] / 5;
                        int count = 0;

                        for (int d = 0; d < 4; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];

                            if (ny >= 0 && ny < r && nx >= 0 && nx < c && map[ny][nx] != -1) {
                                spread[ny][nx] += spreadAmount;
                                count++;
                            }
                        }
                        spread[i][j] -= spreadAmount * count;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    map[i][j] += spread[i][j];
                }
            }

            // 공기청정기 작동

            // 윗 공기청정기 - 반시계 방향
            for (int i = upperIdx - 1; i > 0; i--) map[i][0] = map[i - 1][0];
            for (int i = 0; i < c - 1; i++) map[0][i] = map[0][i + 1];
            for (int i = 0; i < upperIdx; i++) map[i][c - 1] = map[i + 1][c - 1];
            for (int i = c - 1; i > 1; i--) map[upperIdx][i] = map[upperIdx][i - 1];
            map[upperIdx][1] = 0;

            // 아랫 공기청정기 - 시계 방향
            for (int i = downIdx + 1; i < r - 1; i++) map[i][0] = map[i + 1][0];
            for (int i = 0; i < c - 1; i++) map[r - 1][i] = map[r - 1][i + 1];
            for (int i = r - 1; i > downIdx; i--) map[i][c - 1] = map[i - 1][c - 1];
            for (int i = c - 1; i > 1; i--) map[downIdx][i] = map[downIdx][i - 1];
            map[downIdx][1] = 0;
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }

        System.out.println(answer);
    }
}
