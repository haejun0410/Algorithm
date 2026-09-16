import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        int node;
        int dist;
        
        Edge(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
    
    public int solution(int n, int[][] costs) {
        
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] cost : costs) {
            adj.get(cost[0]).add(new Edge(cost[1], cost[2]));
            adj.get(cost[1]).add(new Edge(cost[0], cost[2]));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(0, 0));
        
        int totalCost = 0;
        int edgeCount = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            if (visited[current.node]) continue;
            
            visited[current.node] = true;
            totalCost += current.dist;
            edgeCount++;
            
            if (edgeCount == n) break;
            
            for (Edge next : adj.get(current.node)) {
                if (!visited[next.node]) {
                    pq.add(next);
                }
            }
        }
        
        return totalCost;
    }
}