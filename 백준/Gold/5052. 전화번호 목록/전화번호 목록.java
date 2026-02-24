import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            Trie trie = new Trie();
            boolean flag = true;
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String number = br.readLine();
                if (!trie.insert(number)) {
                    flag = false;
                    continue;
                }
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    public static class Node {
        Node[] child; // HashMap 대신 배열 사용
        boolean endOfWord;

        Node() {
            child = new Node[10];
            endOfWord = false;
        }
    }

    public static class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        public boolean insert(String word) {
            Node node = this.root;
            boolean isNewNodeCreated = false;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - '0';
                
                if (node.child[idx] == null) {
                    node.child[idx] = new Node();
                    isNewNodeCreated = true; // 새 노드가 하나라도 만들어졌는지 체크
                }
                node = node.child[idx];
                
                // 경우 1: 지나가는 길에 끝나는 단어가 있음
                if (node.endOfWord) return false; 
            }
            
            node.endOfWord = true;
            
            // 경우 2: 새 노드를 하나도 안 만들었다면, 현재 단어가 다른 단어의 접두어라는 뜻
            return isNewNodeCreated; 
        }
    }
}
