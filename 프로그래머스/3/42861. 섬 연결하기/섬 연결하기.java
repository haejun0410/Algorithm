import java.util.*;

class Solution {
    int[] parent;
    
    public int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
    
    public int solution(int n, int[][] costs) {
        int totalCost = 0;
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];
            
            if (find(from) != find(to)) {
                union(from, to);
                totalCost += weight;
            }
        }
        
        return totalCost;
    }
}