import java.util.*;
import java.io.*;

public class Main {

	public static class Node implements Comparable<Node>{
		int idx;
		int dist;
		int count;
		
		Node(int idx, int dist) {
			this.idx = idx;
			this.dist = dist;
			this.count = 0;
		}
		
		Node(int idx, int dist, int count) {
			this.idx = idx;
			this.dist = dist;
			this.count = count;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	static ArrayList<Node>[] adj;
	static ArrayList<int[]> candidates;
	static int[][] distance;
	
	static int n;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 수
        n = Integer.parseInt(st.nextToken());
        // 도로의 수
        int m = Integer.parseInt(st.nextToken());
        // 세금 인상 횟수
        int k = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        // 출발 도시
        int s = Integer.parseInt(st.nextToken());
        // 도착 도시
        int d = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	adj[a].add(new Node(b, c));
        	adj[b].add(new Node(a, c));
        }
        
        // 0 : idx, 1: 지나간 도로 수, val : 거리
        distance = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
        	Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        candidates = new ArrayList<>();
        int pre = dijkstra(s, d);
        sb.append(pre).append("\n");
        int sum = 0;
        
        for (int i = 0; i < k; i++) {
        	sum += Integer.parseInt(br.readLine());
        	int min = Integer.MAX_VALUE;
        	for(int[] target : candidates) {
        		min = Math.min(min, target[0] + target[1] * sum);
        	}
        	sb.append(min).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    public static int dijkstra(int start, int end) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.offer(new Node(start, 0, 0));
    	distance[start][0] = 0;
    	int ans = Integer.MAX_VALUE;
    	
    	while(!pq.isEmpty()) {
    		Node curr = pq.poll();
    		
    		if (distance[curr.idx][curr.count] < curr.dist ) continue;
    		
    		for (Node next : adj[curr.idx]) {
    		    int nextCount = curr.count + 1;
    		    if (nextCount >= distance.length) continue;

    		    int nextDist = curr.dist + next.dist;
    		    
    		    boolean isPossible = true;
    		    for (int i = 0; i <= nextCount; i++) {
    		        if (distance[next.idx][i] <= nextDist) {
    		            isPossible = false;
    		            break;
    		        }
    		    }

    		    if (isPossible) {
    		        distance[next.idx][nextCount] = nextDist;
    		        pq.offer(new Node(next.idx, nextDist, nextCount));
    		    }
    		}
    	}
    	
    	for (int i = 0; i < n+1; i++) {
    		if (distance[end][i] != Integer.MAX_VALUE) {
    			candidates.add(new int[] {distance[end][i], i});
    			ans = Math.min(ans, distance[end][i]);
    		}
    	}
    	return ans;
    }
    
}