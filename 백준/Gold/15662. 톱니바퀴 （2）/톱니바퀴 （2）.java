import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] gears = new int[n][8];

        // 톱니바퀴 상태 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] dirs = new int[n];
            dirs[num] = dir;

            // 왼쪽으로 전파
            for (int j = num - 1; j >= 0; j--) {
                if (gears[j][2] != gears[j + 1][6]) {
                    dirs[j] = -dirs[j + 1];
                } else {
                    break;
                }
            }

            // 오른쪽으로 전파
            for (int j = num + 1; j < n; j++) {
                if (gears[j - 1][2] != gears[j][6]) {
                    dirs[j] = -dirs[j - 1];
                } else {
                    break;
                }
            }

            // 회전
            for (int j = 0; j < n; j++) {
                if (dirs[j] != 0) {
                    rotate(gears[j], dirs[j]);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (gears[i][0] == 1) cnt++;
        }

        System.out.println(cnt);
    }


    static void rotate(int[] gear, int dir) {
        if (dir == 1) { // 시계 방향
            int temp = gear[7];
            for (int i = 7; i > 0; i--) {
                gear[i] = gear[i - 1];
            }
            gear[0] = temp;
        } 
        else if (dir == -1) { // 반시계 방향
            int temp = gear[0];
            for (int i = 0; i < 7; i++) {
                gear[i] = gear[i + 1];
            }
            gear[7] = temp;
        }
    }
}
