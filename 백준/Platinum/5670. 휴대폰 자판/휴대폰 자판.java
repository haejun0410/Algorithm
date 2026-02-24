import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                trie.insert(br.readLine().trim());
            }
            sb.append(String.format("%.2f\n", trie.calculate() / n));
        }

        System.out.print(sb);
    }

    public static class Node {
        HashMap<Character, Node> child;
        boolean isEnd;

        Node() {
            this.child = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static class Trie {
        Node root;
        double sum;

        Trie() {
            this.root = new Node();
            this.sum = 0;
        }

        public void insert(String word) {
            Node node = this.root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                node.child.putIfAbsent(ch, new Node());
                node = node.child.get(ch);
            }

            node.isEnd = true;
        }

        public double calculate() {
            recursion(this.root, 0);
            return this.sum;
        }

        public void recursion(Node curr, int presses) {
            if (curr.isEnd) {
                this.sum += presses;
            }

            for (Character key : curr.child.keySet()) {
                Node next = curr.child.get(key);
                int nextPresses = presses;
                
                if (curr == this.root || curr.child.size() > 1 || curr.isEnd) {
                    nextPresses++;
                }

                recursion(next, nextPresses);
            }
        }
    }
}