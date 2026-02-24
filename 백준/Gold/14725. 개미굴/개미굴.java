import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            String[] foods = new String[num];

            for (int j = 0; j < num; j++) {
                foods[j] = st.nextToken();
            }

            trie.insert(foods);
        }

        System.out.println(trie.print());

    }

    public static class Node {
        TreeMap<String, Node> children;
        boolean isEnd;

        Node() {
            this.children = new TreeMap<>();
            this.isEnd = false;
        }
    }

    public static class Trie {
        Node root;
        StringBuilder sb;

        Trie() {
            root = new Node();
        }

        public void insert(String[] foods) {
            Node node = this.root;

            for (String food : foods) {
                node.children.putIfAbsent(food, new Node());
                node = node.children.get(food);
            }
            node.isEnd = true;
        }

        public String print() {
            this.sb = new StringBuilder();
            
            Node node = this.root;
            print(node, 0);
            return sb.toString();
        }

        private void print(Node curr, int depth) {
            for (String key : curr.children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append("-"); 
                }
                sb.append(key).append("\n");
                Node next = curr.children.get(key);
                print(next, depth + 2);
            }   
        }
    }

}
