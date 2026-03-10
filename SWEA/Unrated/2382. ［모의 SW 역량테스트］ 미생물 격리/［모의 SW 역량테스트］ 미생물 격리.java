import java.util.*;
import java.io.*;

public class Solution {
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};

    static class Microbe implements Comparable<Microbe>{
        int y;
        int x;
        int cnt;
        int dir;

        Microbe(int y, int x, int cnt, int dir) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.dir = dir;
        }

        @Override
        public int compareTo(Microbe o) {
            if (this.x != o.x) return this.x - o.x;
            if (this.y != o.y) return this.y - o.y;
            // 좌표가 같을 때, 수가 더 많은 미생물이 앞에 오도록
            // 큰 쪽이 방향을 결정하기 때문
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Microbe> microbes = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                microbes.add(new Microbe(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ));
            }

            for (int time = 0; time < M; time++) {
                for (Microbe m : microbes) {
                    m.y += dy[m.dir];
                    m.x += dx[m.dir];

                    // 약품 구역
                    if (m.y == 0 || m.y == N - 1 || m.x == 0 || m.x == N - 1) {
                        m.cnt /= 2;
                        m.dir = (m.dir % 2 == 0) ? m.dir - 1 : m.dir + 1;
                    }
                }

                Collections.sort(microbes);

                for (int i = 0; i < microbes.size() - 1; i++) {
                    Microbe cur = microbes.get(i);
                    Microbe next = microbes.get(i + 1);

                    if (cur.y == next.y && cur.x == next.x) {
                        cur.cnt += next.cnt;
                        microbes.remove(i + 1);
                        // 뒤에서 또 합쳐질 수 있으므로 한번 더 체크해야함.
                        i--;
                    }
                }
                for (int i = 0; i < microbes.size(); i++) {
                    if (microbes.get(i).cnt ==0) {
                        microbes.remove(i);
                    }
                }
            }

            int sum = 0;
            for (Microbe m : microbes) {
                sum += m.cnt;
            }
            sb.append("#").append(testCase).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}