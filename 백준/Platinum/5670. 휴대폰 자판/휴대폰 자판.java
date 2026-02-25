import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 속도가 빠른 입력 방식 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n;
            try {
                n = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                break;
            }

            Trie trie = new Trie();
            for (int i = 0; i < n; i++) {
                trie.insert(br.readLine().trim());
            }

            // 평균값 계산 및 출력 (소수점 둘째 자리까지)
            double result = (double) trie.calculate() / n;
            System.out.printf("%.2f\n", result);
        }
    }

    static class Node {
        // 알파벳 소문자 26개를 위한 배열 (HashMap보다 빠름)
        Node[] children = new Node[26];
        int childCount = 0;
        boolean isEnd = false;
    }

    static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                    curr.childCount++; // 자식 노드 개수 카운트
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }

        public long calculate() {
            long totalSum = 0;
            // 루트의 자식들부터 재귀 시작 (첫 글자는 무조건 눌러야 함)
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    totalSum += getPressCount(root.children[i], 1);
                }
            }
            return totalSum;
        }

        private long getPressCount(Node curr, int presses) {
            long sum = 0;
            // 현재 노드가 단어의 끝이라면 현재까지의 누름 횟수를 더함
            if (curr.isEnd) {
                sum += presses;
            }

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    // 다음 글자를 입력할 때 버튼을 눌러야 하는 조건:
                    // 1. 자식이 2개 이상인 분기점일 때
                    // 2. 현재 노드에서 단어가 끝날 때 (isEnd가 true인 지점)
                    int nextPresses = presses;
                    if (curr.childCount > 1 || curr.isEnd) {
                        nextPresses++;
                    }
                    sum += getPressCount(curr.children[i], nextPresses);
                }
            }
            return sum;
        }
    }
}