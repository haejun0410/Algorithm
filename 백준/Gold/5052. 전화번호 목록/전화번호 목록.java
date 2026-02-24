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
            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
            }

            Arrays.sort(numbers, (e1, e2) -> {
                if (e1.length() == e2.length()) {
                    return e1.compareTo(e2);
                }
                else {
                    return e1.length() - e2.length();
                }
            });

            for (String number : numbers) {
                if (!trie.insert(number)) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    public static class Node {
        HashMap<Character, Node> child;
        boolean endOfWord;

        Node() {
            child = new HashMap<>();
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

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (!node.child.containsKey(ch)) {
                    node.child.put(ch, new Node());
                }
                node = node.child.get(ch);

                if (node.endOfWord) {
                    return false;
                }
            }

            node.endOfWord = true;
            return true;
        }
    }
}