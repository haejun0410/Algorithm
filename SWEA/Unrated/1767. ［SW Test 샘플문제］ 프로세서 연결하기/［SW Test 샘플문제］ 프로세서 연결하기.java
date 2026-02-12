import java.sql.Array;
import java.util.*;
import java.io.*;

public class Solution {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static ArrayList<int[]> cores;
    static int numCore;
    static int n;
    static int[][] board;
    static int answer;
    static int minLength;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= TC; testCase++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            // 가장자리에 있는 코어로, 전선을 놓지 않아도 전원이 연결된 상태
            int connected = 0;

            cores = new ArrayList<>();
            for(int i = 0; i < n ; i++) {
                String line = br.readLine();
                for(int j = 0; j < n; j++) {
                    board[i][j] = line.charAt(j*2) - '0';
                    if (board[i][j] == 1) {
                        if (i == 0 || j == 0 || i == n-1 || j == n-1) {
                            connected++;
                        }
                        else {
                            cores.add(new int[] {i, j});
                        }
                    }
                }
            }
            numCore = cores.size();
            answer = 0;
            minLength = Integer.MAX_VALUE;

            connect(0, 0, 0);

            sb.append("#").append(testCase).append(" ").append(minLength).append("\n");
        }
        System.out.print(sb);

    }
    // idx 번째 core에서 4방향으로 전선 놓기 시도
    public static void connect(int idx, int count, int len) {

        // 모든 코어에 대해 시뮬레이션 완료
        if (idx == numCore) {
            // 1. 더 많은 코어를 연결한 경우
            if (count > answer) {
                // 무조건 갱신
                answer = count;
                minLength = len;
            }
            // 2. 연결 코어 수가 같은 경우 최소 길이 선택
            else if (count == answer) {
                minLength = Math.min(minLength, len);
            }
            return;
        }

        int[] core = cores.get(idx);
        int y = core[0];
        int x = core[1];

        // 놓을 방향 (i == 방향)
        for (int i = 0; i < 4; i++) {
            // 전선 놓기
            if (isAvailable(y, x, i)) {
                // 다음 코어로
                int tmp = setStatus(y, x, i, 2);
                connect(idx+1, count+1, len + tmp);
                setStatus(y, x, i, 0);
                // 놓았던 전선 해체
            }
        }

        // 전선을 놓지 않음
        connect(idx+1, count, len);
    }

    public static boolean isAvailable(int y, int x, int dir) {
        while(true) {
            y = y + dy[dir];
            x = x + dx[dir];

            if (y < 0 || y >=n || x < 0 || x >= n) {
                break;
            }

            // 범위 밖을 벗어나지 않았는데, 빈 공간이 아님 ->놓을 수 없음
            if (board[y][x] != 0) {
                return false;
            }

        }

        return true;
    }

    public static int setStatus(int y, int x, int dir, int status) {
        int cnt = 0;
        while (true) {
            y = y + dy[dir];
            x = x + dx[dir];

            if (y < 0 || y >=n || x < 0 || x >= n) {
                break;
            }

            board[y][x] = status;
            cnt++;

        }

        return cnt;
    }
}
