import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node {
		Node[] childs;
		boolean isEnd;
		
		Node() {
			this.childs = new Node[26];
			this.isEnd = false;
		}
	}
	
	public static class Trie {
		Node root;
		
		Trie() {
			this.root = new Node();
		}
		
		public void insert(String str) {
			Node node = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				
				if (node.childs[idx] == null) {
					node.childs[idx] = new Node();
				}
				
				node = node.childs[idx];
			}
			
			node.isEnd = true;
		}
		
		public boolean search(String str) {
			Node node = this.root;
			
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				
				if (node.childs[idx] == null) {
					return false;
				}
				node = node.childs[idx];
			}
			
			return true;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Trie trie = new Trie();
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			trie.insert(word);
		}
		
		int count = 0;
		for (int i = 0; i < m; i++) {
			String word = br.readLine();
			if (trie.search(word)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}