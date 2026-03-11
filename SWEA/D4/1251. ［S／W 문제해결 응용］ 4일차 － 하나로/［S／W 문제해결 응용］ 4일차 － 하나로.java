import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static double E, answer;
    static int[][] nodes;
    static boolean[] visited;
    static double[] minEdge;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {

            N = Integer.parseInt(br.readLine());
            nodes = new int[N][2];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nodes[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nodes[i][1] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            visited = new boolean[N];
            minEdge = new double[N];

            Arrays.fill(minEdge, Double.MAX_VALUE);
            minEdge[0] = 0;

            answer = 0;

            for (int i = 0; i < N; i++) {

                int minVertex = -1;
                double min = Double.MAX_VALUE;

                // 가장 작은 간선 찾기
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && minEdge[j] < min) {
                        minVertex = j;
                        min = minEdge[j];
                    }
                }

                visited[minVertex] = true;
                answer += min;

                // 거리 업데이트
                for (int j = 0; j < N; j++) {
                    if (!visited[j]) {
                        double dx = nodes[minVertex][0] - nodes[j][0];
                        double dy = nodes[minVertex][1] - nodes[j][1];

                        double dist = dx * dx + dy * dy;
                        double cost = E * dist;

                        if (minEdge[j] > cost) {
                            minEdge[j] = cost;
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(Math.round(answer)).append("\n");
        }

        System.out.println(sb);

    }

}