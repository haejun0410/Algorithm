import java.io.*;
import java.util.*;

public class Main {
    // 배열 기반 인접 리스트 변수들
    static int[] head;   // 각 정점의 첫 번째 간선 번호
    static int[] next;   // 다음 간선 번호 (연결 리스트의 next 역할)
    static int[] to;     // 목적지 노드 번호
    static int[] weight; // 간선의 가중치
    static int edgeCount = 0; // 현재까지 추가된 간선의 총 개수

    static int[] maxWeight; // 다익스트라에서 각 노드까지의 '최대 경로 중 최소 중량' 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화: 간선은 양방향이므로 M * 2 크기로 설정
        head = new int[n + 1];
        Arrays.fill(head, -1); // -1은 연결된 간선이 없음을 의미
        
        next = new int[m * 2];
        to = new int[m * 2];
        weight = new int[m * 2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // 양방향 간선 추가
            addEdge(u, v, w);
            addEdge(v, u, w);
        }

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        maxWeight = new int[n + 1];
        Arrays.fill(maxWeight, -1);

        dijkstra(p1);

        System.out.println(maxWeight[p2]);
    }

    // 간선을 배열에 추가하는 핵심 로직
    static void addEdge(int u, int v, int w) {
        to[edgeCount] = v;
        weight[edgeCount] = w;
        next[edgeCount] = head[u]; // 현재 노드(u)의 기존 머리(head)를 내 다음으로 설정
        head[u] = edgeCount++;      // 내가 u의 새로운 머리(head)가 됨
    }

    public static void dijkstra(int start) {
        // PriorityQueue에는 [현재노드, 현재까지의최소중량] 저장
        // 최대값을 찾아야 하므로 중량 기준 내림차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        maxWeight[start] = Integer.MAX_VALUE;
        pq.offer(new int[] {start, Integer.MAX_VALUE});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int currentMinW = curr[1];

            // 이미 더 큰 최소 중량 경로를 찾았다면 건너뜀
            if (maxWeight[u] > currentMinW) continue;

            // head 배열부터 시작해서 next를 따라가며 모든 인접 간선 순회
            for (int i = head[u]; i != -1; i = next[i]) {
                int v = to[i];
                int w = weight[i];

                // 새로운 경로의 최소 중량 계산
                int nextMinW = Math.min(currentMinW, w);

                // 만약 이 경로를 통해 v로 가는 것이 기존보다 더 큰 중량을 버틸 수 있다면 갱신
                if (maxWeight[v] < nextMinW) {
                    maxWeight[v] = nextMinW;
                    pq.offer(new int[] {v, nextMinW});
                }
            }
        }
    }
}