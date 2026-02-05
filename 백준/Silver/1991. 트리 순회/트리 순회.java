import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
        }
    }
    static Node[] trees;
    static StringBuilder sb;

    public static void preOrder(Node node) {
        if (node != null) {
            sb.append(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            sb.append(node.data);
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            sb.append(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        trees = new Node[27];
        sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char parent = line.charAt(0);
            char leftChild = line.charAt(2);
            char rightChild = line.charAt(4);

            if (trees[parent - 'A'] == null) {
                trees[parent - 'A'] = new Node(parent);
            }
            if (leftChild != '.') {
                trees[leftChild - 'A'] = new Node(leftChild);
                trees[parent - 'A'].left = trees[leftChild - 'A'];
            }
            if (rightChild != '.') {
                trees[rightChild - 'A'] = new Node(rightChild);
                trees[parent - 'A'].right = trees[rightChild - 'A'];
            }

        }
        preOrder(trees[0]);
        sb.append("\n");
        inOrder(trees[0]);
        sb.append("\n");
        postOrder(trees[0]);

        System.out.print(sb);

    }
}