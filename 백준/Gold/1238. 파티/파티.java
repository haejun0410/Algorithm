import java.util.*;
import java.io.*;
/**
 * 각 요원이 X도시로 가는 경로에 대한 거리를 계산 하는 것 보단(다익스트라 n번),
 * 도시 X에서 각 요원들까지의 거리로 역산하는 것이(다익스트라 1번) 낫다. 
 * 
 *  간선을 입력받을 때
 *  도시 -> x용
 *  x -> 도시
 *  경우를 둘 다 고려해서 서로 반대로 받아줌.
 *  adj[u].add(new Edge(v, c)); - x에서 도시로 돌아올 때 비용 계산용
	revAdj[v].add(new Edge(u, c)); - 도시에서 X로 가는 비용 계산용
	
	위 2가지 경우를 각각 다익스트라를 해서
	distance[idx] + revDistance[idx]의 값이 가장 큰 것이 정답이 된다. 
 *  
 * */
public class Main{
	
	public static class Edge implements Comparable<Edge>{
		int idx;
		int dist;
		
		Edge(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
		
		
	}
	
	static int n,m,x;
	static ArrayList<Edge>[] adj;
	static ArrayList<Edge>[] revAdj;
	static int[] distance;
	static int[] revDistance;
	
	
	public static void main(String[] args) throws IOException{
		//------여기에 솔루션 코드를 작성하세요.------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도시의 수
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1]; 
		revAdj = new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
			revAdj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Edge(v, c));
			revAdj[v].add(new Edge(u, c));
		}
		
		// X도시 -> 요원들의 원래 도시
		distance = new int[n+1];
		// 요원 -> X도시
		revDistance = new int[n+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(revDistance, Integer.MAX_VALUE);
		
		dijkstra(x);
		revDijkstra(x);
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = distance[i] + revDistance[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (distance[curr.idx] < curr.dist) continue;
			
			for (Edge next : adj[curr.idx]) {
				if (distance[next.idx] > next.dist + curr.dist ) {
					distance[next.idx]= next.dist + curr.dist;
					pq.offer(new Edge(next.idx, distance[next.idx]));
				}
			}
		}
	}
	
	public static void revDijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		revDistance[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (revDistance[curr.idx] < curr.dist) continue;
			
			for (Edge next : revAdj[curr.idx]) {
				if (revDistance[next.idx] > next.dist + curr.dist ) {
					revDistance[next.idx]= next.dist + curr.dist;
					pq.offer(new Edge(next.idx, revDistance[next.idx]));
				}
			}
		}
	}
}