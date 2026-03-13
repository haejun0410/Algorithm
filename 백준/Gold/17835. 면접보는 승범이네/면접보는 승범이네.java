import java.util.*;
import java.io.*;

public class Main {
	
	public static class Edge implements Comparable<Edge>{
		int idx;
		long dist;
		
		Edge(int idx, long dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dist, o.dist);
		}
	}
	
	static long[] distance;
	static ArrayList<Edge>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// number of city
		int n = Integer.parseInt(st.nextToken());
		// number of road
		int m = Integer.parseInt(st.nextToken());
		// number of meetingRoom
		int k = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			adj[v].add(new Edge(u, c));
		}
		
		int[] list = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		distance = new long[n+1];
		Arrays.fill(distance, Long.MAX_VALUE);
		dijkstra(list);
		
		int idx = -1;
		long dist = 0;
		
		for (int i = 1; i <= n; i++) {
			if(distance[i] > dist && distance[i] != Long.MAX_VALUE) {
				idx = i;
				dist = distance[i];
			}
		}
		
		System.out.println(idx);
		System.out.println(dist);
		
	}
	
	public static void dijkstra(int[] list) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int n : list) {
			pq.offer(new Edge(n, 0));
			distance[n] = 0;
		}
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if (distance[curr.idx] < curr.dist) continue;
			
			for (Edge next : adj[curr.idx]) {
				if (distance[next.idx] > curr.dist + next.dist) {
					distance[next.idx] = curr.dist + next.dist;
					pq.offer(new Edge(next.idx, distance[next.idx]));
				}
			}
		}
	}
}