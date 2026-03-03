import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        
        Set<String> nodes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            if (!st.hasMoreTokens()) continue;
            String pre = st.nextToken();
            String next = st.nextToken();

            nodes.add(pre);
            nodes.add(next);

            adj.putIfAbsent(pre, new ArrayList<>());
            adj.putIfAbsent(next, new ArrayList<>());
            adj.get(pre).add(next);

            indegree.put(next, indegree.getOrDefault(next, 0) + 1);
            indegree.putIfAbsent(pre, 0);
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String node : nodes) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            PriorityQueue<String> newQueue = new PriorityQueue<>();
            for (int i = 0; i < queueSize; i++) {
                String curr = queue.poll();
                sb.append(curr).append("\n");
                count++;

                if (adj.containsKey(curr)) {
                    for (String next : adj.get(curr)) {
                        indegree.put(next, indegree.get(next) - 1);
                        if (indegree.get(next) == 0) {
                            newQueue.offer(next);
                        }
                    }
                }
            }
            queue = newQueue;
            
        }

        if (count != nodes.size()) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }
}