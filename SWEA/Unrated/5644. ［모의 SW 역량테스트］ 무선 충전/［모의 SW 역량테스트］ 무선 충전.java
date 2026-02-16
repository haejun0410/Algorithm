import java.util.*;
import java.io.*;

public class Solution {
    // 0: 이동 x, 1 : 상, 2 : 우, 3 : 하, 4 : 좌
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, 1, 0, -1};
    static int[][] aMove;
    static int[][] bMove;

    public static class BC {
        int y;
        int x;
        int c;
        int p;

        public BC(int y, int x, int c, int p) {
            this.y = y;
            this.x = x;
            this.c = c;
            this.p = p;
        }
    }

    public static int getPower(int y, int x, BC node) {
        int dist = Math.abs(y - node.y) + Math.abs(x - node.x);
        return dist <= node.c ? node.p : 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 총 이동 시간
            int a = Integer.parseInt(st.nextToken()); // 충전소(BC)의 수

            // 사용자 A, B의 경로를 저장
            aMove = new int[m + 1][2];
            bMove = new int[m + 1][2];

            // 시작점 (0,0)과 (9,9) 설정
            int ay = 0, ax = 0;
            int by = 9, bx = 9;
            aMove[0][0] = ay; aMove[0][1] = ax;
            bMove[0][0] = by; bMove[0][1] = bx;

            // A 이동 경로 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                int dir = Integer.parseInt(st.nextToken());
                ay += dy[dir]; ax += dx[dir];
                aMove[i][0] = ay; aMove[i][1] = ax;
            }

            // B 이동 경로 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                int dir = Integer.parseInt(st.nextToken());
                by += dy[dir]; bx += dx[dir];
                bMove[i][0] = by; bMove[i][1] = bx;
            }

            // 충전소
            BC[] stations = new BC[a];
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) -1;
                int y = Integer.parseInt(st.nextToken()) -1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                stations[i] = new BC(y, x, c, p);
            }

            int totalVal = 0;

            for (int time = 0; time <= m; time++) {
                ay = aMove[time][0]; ax = aMove[time][1];
                by = bMove[time][0]; bx = bMove[time][1];

                // 조합
                int maxVal = 0;

                // A의 선택
                for (int i = 0; i < a; i++) {
                    // B의 선택
                    for (int j = 0; j < a; j++) {

                        int currentSum = 0;
                        int pA = getPower(ay, ax, stations[i]);
                        int pB = getPower(by, bx, stations[j]);

                        if (i != j) {
                            currentSum = pA + pB;
                        } else {
                            currentSum = Math.max(pA, pB);
                        }
                        maxVal = Math.max(maxVal, currentSum);
                    }
                }
                totalVal += maxVal;
            }

            sb.append("#").append(testCase).append(" ").append(totalVal).append("\n");
        }
        System.out.print(sb);
    }
}