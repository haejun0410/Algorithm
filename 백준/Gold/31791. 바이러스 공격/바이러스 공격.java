import java.util.*;
import java.io.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int G = Integer.parseInt(st.nextToken()); // 총 시간
        int B = Integer.parseInt(st.nextToken()); // 내구도
        int X = Integer.parseInt(st.nextToken()); // (문제의 추가 변수 X)
        int numBuilding = Integer.parseInt(st.nextToken());

        int[][] boardType = new int[n][m]; // 0: 빈칸, 1: 건물, 2: 초기 바이러스
        int[][] minTime = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                if (c == '*') { // 초기 바이러스
                    boardType[i][j] = 2;
                    minTime[i][j] = 0;
                    pq.add(new int[]{0, i, j});
                } else if (c == '#') {
                    boardType[i][j] = 1;
                } else {
                    boardType[i][j] = 0;
                }
            }
        }

        // 다익스트라 수행
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0];
            int y = curr[1];
            int x = curr[2];

            if (t > minTime[y][x]) continue;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    // 다음 칸이 바이러스가 되는 데 걸리는 비용 계산
                    int cost = (boardType[ny][nx] == 1) ? B + 1 : 1;
                    int nextT = t + cost;

                    if (nextT <= G && nextT < minTime[ny][nx]) {
                        minTime[ny][nx] = nextT;
                        pq.add(new int[]{nextT, ny, nx});
                    }
                }
            }
        }

        // 결과 출력 (G시간 이후에도 바이러스가 되지 않은 칸)
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 초기 바이러스도 아니고, 걸린 시간이 G를 초과하면 생존
                if (boardType[i][j] != 2 && minTime[i][j] > G) {
                    sb.append((i + 1)).append(" ").append((j + 1)).append("\n");
                    count++;
                }
            }
        }

        if (count == 0) System.out.println(-1);
        else System.out.print(sb);
    }
}