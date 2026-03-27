import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        Node[] children = new Node[2];
        int count = 0;
    }

    static Node root;
    // 최대 30비트면 10^9까지의 수를 표현할 수 있음
    static final int MAX_BIT = 30;

    // 숫자 추가
    // 높은 비트부터 위를 채움
    public static void insert(int num) {
        Node curr = root;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
            curr.count++;
        }
    }

    // 숫자 제거
    public static void delete(int num) {
        Node curr = root;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            curr = curr.children[bit];
            curr.count--;
        }
    }

    // XOR 최댓값 찾기
    public static int findMaxXor(int num) {
        Node curr = root;
        int maxXor = 0;
        for (int i = MAX_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            // XOR 되므로 반대 비트를 찾아야 함.
            int targetBit = 1 - bit;

            // 반대 방향 비트가 존재하고, 삭제되지 않은 노드(count > 0)인 경우
            if (curr.children[targetBit] != null && curr.children[targetBit].count > 0) {
                maxXor |= (1 << i);
                curr = curr.children[targetBit];
            } else {
                curr = curr.children[bit];
            }
        }
        return maxXor;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        root = new Node();
        insert(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (command == 1) {
                insert(num);
            } 
            else if (command == 2) {
                delete(num);
            } 
            else {
                sb.append(findMaxXor(num)).append("\n");
            }
        }
        System.out.print(sb);
    }
}