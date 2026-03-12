import java.util.*;
import java.io.*;

public class Main {
    
    public static class SegmentTree {
        int[] tree;
        int S = 1; // 단말 노드의 시작 인덱스
        
        SegmentTree() {
            // 2,000,000을 수용하는 가장 작은 2의 거듭제곱 (2,097,152)
            while (S < 2000000) S <<= 1;
            tree = new int[S * 2];
        }
        
        // 반복문을 이용한 업데이트 (매우 빠름)
        public void update(int idx, int diff) {
            int node = S + idx - 1;
            while (node > 0) {
                tree[node] += diff;
                node /= 2;
            }
        }
        
        // 반복문을 이용한 K번째 찾기 (매우 빠름)
        public int query(long k) {
            int node = 1;
            while (node < S) {
                if (tree[node * 2] >= k) {
                    node = node * 2;
                } else {
                    k -= tree[node * 2];
                    node = node * 2 + 1;
                }
            }
            return node - S + 1;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        SegmentTree segTree = new SegmentTree();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if (a == 1) {
                segTree.update(b, 1);
            } else {
                // b번째 수를 찾고 출력 후, 개수를 하나 줄임
                int idx = segTree.query(b);
                segTree.update(idx, -1);
                sb.append(idx).append("\n");
            }
        }
        System.out.print(sb);
    }
}