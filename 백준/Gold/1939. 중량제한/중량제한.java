import java.io.*;
import java.util.*;

public class Main {
    // 배열 기반 인접 리스트
    static int[] head;
    static int[] next;
    static int[] to;
    static int[] weight;
    static int edgeCount = 0;

    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        head = new int[N + 1];
        Arrays.fill(head, -1);
        next = new int[M * 2];
        to = new int[M * 2];
        weight = new int[M * 2];

        int maxWeightLimit = 0; // 이분 탐색의 high 범위를 결정하기 위함
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            addEdge(u, v, w);
            addEdge(v, u, w);
            maxWeightLimit = Math.max(maxWeightLimit, w);
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        // 이분 탐색 (Binary Search)
        int low = 1;
        int high = maxWeightLimit;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // 오버플로우 방지용 계산식

            // mid라는 중량으로 목적지까지 도달 가능한지 체크
            if (canGo(startNode, endNode, mid)) {
                ans = mid;      // 가능하면 정답 후보로 저장하고
                low = mid + 1;  // 더 큰 중량이 가능한지 확인
            } else {
                high = mid - 1; // 불가능하면 중량을 줄임
            }
        }

        System.out.println(ans);
    }

    static void addEdge(int u, int v, int w) {
        to[edgeCount] = v;
        weight[edgeCount] = w;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    // BFS를 이용한 경로 검증
    static boolean canGo(int start, int end, int limit) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == end) return true; // 목적지 도달 성공

            for (int i = head[curr]; i != -1; i = next[i]) {
                int nextNode = to[i];
                int bridgeWeight = weight[i];

                // 아직 방문하지 않았고, 다리의 제한 중량이 현재 테스트 중인 mid(limit) 이상인 경우만 이동
                if (!visited[nextNode] && bridgeWeight >= limit) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }

        return false; // 끝내 도달하지 못함
    }
}