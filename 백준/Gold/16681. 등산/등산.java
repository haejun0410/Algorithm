import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node implements Comparable<Node>{
		int idx;
		long dist;
		
		Node(int idx, long dist) {
			this.idx = idx;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.dist, o.dist);
		}
	}
	
	static ArrayList<Node>[] adj;
	
	static int n;
	static int[] heights;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// n : number of point
		n = Integer.parseInt(st.nextToken());
		// m : number of road
		int m = Integer.parseInt(st.nextToken());
		// d : health lose per distance;
		int d = Integer.parseInt(st.nextToken());
		// e : achieve per distance
		int e = Integer.parseInt(st.nextToken());
		
		heights = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		adj = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[u].add(new Node(v, c));
			adj[v].add(new Node(u, c));
			
		}
		
		long[] distance = dijkstra(1);
		long[] revDistance = dijkstra(n);
		
		
		long maxResult = Long.MIN_VALUE;
		boolean flag = false;
		for (int i = 2; i <= n; i++) {
			if (distance[i] == Long.MAX_VALUE || revDistance[i] == Long.MAX_VALUE) continue;

            long achievement = (long) heights[i] * e;
            long totalCost = (distance[i] + revDistance[i]) * d;
            
            maxResult = Math.max(maxResult, achievement - totalCost);
            flag = true;
		}
		if (flag) {
			System.out.println(maxResult);
		}
		else {
			System.out.println("Impossible");
		}
		
		
		
	}
	
	// 낮은 곳 -> 높은 곳
	public static long[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		long[] dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if (dist[curr.idx] < curr.dist ) continue;
			
			for(Node next : adj[curr.idx]) {
				if (heights[curr.idx] >= heights[next.idx]) continue;
				if (dist[next.idx] > curr.dist + next.dist) {
					dist[next.idx] = curr.dist + next.dist;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
			
		}
		
		return dist;
		
	}
	
}