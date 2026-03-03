import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> nameToId = new HashMap<>();
        List<String> idToName = new ArrayList<>();
        
        List<Integer> preList = new ArrayList<>();
        List<Integer> nextList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String u = st.nextToken();
            String v = st.nextToken();

            if (!nameToId.containsKey(u)) {
                nameToId.put(u, idToName.size());
                idToName.add(u);
            }
            if (!nameToId.containsKey(v)) {
                nameToId.put(v, idToName.size());
                idToName.add(v);
            }

            preList.add(nameToId.get(u));
            nextList.add(nameToId.get(v));
        }

        int nodeCount = idToName.size();
        List<Integer>[] adj = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) adj[i] = new ArrayList<>();
        
        int[] indegree = new int[nodeCount];

        for (int i = 0; i < n; i++) {
            int u = preList.get(i);
            int v = nextList.get(i);
            adj[u].add(v);
            indegree[v]++;
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        PriorityQueue<String> nextQueue = new PriorityQueue<>();

        for (int i = 0; i < nodeCount; i++) {
            if (indegree[i] == 0) {
                queue.offer(idToName.get(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                String currName = queue.poll();
                sb.append(currName).append("\n");
                count++;

                int currId = nameToId.get(currName);
                for (int nextId : adj[currId]) {
                    if (--indegree[nextId] == 0) {
                        nextQueue.offer(idToName.get(nextId));
                    }
                }
            }
            queue.addAll(nextQueue);
            nextQueue.clear();
        }

        if (count != nodeCount) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }
}