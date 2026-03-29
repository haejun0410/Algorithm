import java.io.*;
import java.util.*;

public class Main {
    
    static class Query1 {
        int i, j;
        long k;
        public Query1(int i, int j, long k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    static class Query2 implements Comparable<Query2> {
        int id, i, j, k;
        public Query2(int id, int i, int j, int k) {
            this.id = id;
            this.i = i;
            this.j = j;
            this.k = k;
        }
        
        @Override
        public int compareTo(Query2 o) {
            return Integer.compare(this.k, o.k);
        }
    }

    static long[] tree, lazy;
    static ArrayList<Integer> comp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Query1> q1List = new ArrayList<>();
        ArrayList<Query2> q2List = new ArrayList<>();
        
        int[] tempCoords = new int[N * 2];
        int coordIdx = 0;

        int q2Id = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            if (type == 1) {
                long k = Long.parseLong(st.nextToken());
                q1List.add(new Query1(i, j, k));
            } else {
                int k = Integer.parseInt(st.nextToken());
                q2List.add(new Query2(q2Id++, i, j, k));
            }
            tempCoords[coordIdx++] = i;
            tempCoords[coordIdx++] = j + 1;
        }

        Arrays.sort(tempCoords, 0, coordIdx);
        comp = new ArrayList<>();
        comp.add(tempCoords[0]);
        for (int i = 1; i < coordIdx; i++) {
            if (tempCoords[i] != tempCoords[i - 1]) {
                comp.add(tempCoords[i]);
            }
        }

        int M = comp.size();
        tree = new long[M * 4];
        lazy = new long[M * 4];

        Collections.sort(q2List);

        long[] ans = new long[q2Id];
        int currentQ1Idx = 0;

        for (Query2 q2 : q2List) {
            while (currentQ1Idx < q2.k && currentQ1Idx < q1List.size()) {
                Query1 q1 = q1List.get(currentQ1Idx);
                int left = getIndex(q1.i);
                int right = getIndex(q1.j + 1) - 1;
                update(1, 0, M - 2, left, right, q1.k);
                currentQ1Idx++;
            }

            int left = getIndex(q2.i);
            int right = getIndex(q2.j + 1) - 1;
            ans[q2.id] = query(1, 0, M - 2, left, right);
        }

        for (int i = 0; i < q2Id; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int getIndex(int val) {
        int left = 0, right = comp.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (comp.get(mid) == val) return mid;
            if (comp.get(mid) < val) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            long length = comp.get(end + 1) - comp.get(start);
            tree[node] += lazy[node] * length;
            
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int left, int right, long val) {
        propagate(node, start, end);
        if (left > end || right < start) return;
        if (left <= start && end <= right) {
            long length = comp.get(end + 1) - comp.get(start);
            tree[node] += val * length;
            if (start != end) {
                lazy[node * 2] += val;
                lazy[node * 2 + 1] += val;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, val);
        update(node * 2 + 1, mid + 1, end, left, right, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    
    static long query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }
}