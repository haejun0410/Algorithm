import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node {
		Node[] children;
		boolean isEnd;
		
		Node() {
			this.children = new Node[26];
			this.isEnd = false;
		}
	}
	
	public static class Trie {
		Node root;
		
		Trie() {
			this.root = new Node();
		}
		
		public void insert(String word) {
			Node node = this.root;
			for(int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'A';
				if (node.children[idx] == null) {
					node.children[idx] = new Node();
				}
				node = node.children[idx];
			}
			node.isEnd = true;
		}
	}
	
	static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
	static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
	static int[] scores = {0, 0, 0, 1, 1, 2, 3, 5, 11};
	
	static char[][] board;
	static boolean[][] visited;
	static Set<String> foundWords;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int w = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		for(int i = 0; i < w; i++) {
			trie.insert(br.readLine());
		}
		
		br.readLine();
		int b = Integer.parseInt(br.readLine());
		
		board = new char[4][4];
		
		for (int iter = 0 ; iter < b; iter++) {
			for (int i = 0; i < 4; i++) {
				board[i] = br.readLine().toCharArray();
			}
			if (iter < b - 1) {
				br.readLine();
			}
			
			visited = new boolean[4][4];
			foundWords = new HashSet<>();
			sb = new StringBuilder();
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int idx = board[i][j] - 'A';
					if (trie.root.children[idx] != null) {
						visited[i][j] = true;
						sb.append(board[i][j]);
						
						recursion(i, j, trie.root.children[idx]);
						
						sb.deleteCharAt(sb.length() - 1);
						visited[i][j] = false;
					}
				}
			}
			
			int totalScore = 0;
			String longestWord = "";
			
			for (String word : foundWords) {
				totalScore += scores[word.length()];
				
				if (word.length() > longestWord.length()) {
					longestWord = word;
				} else if (word.length() == longestWord.length()) {
					if (word.compareTo(longestWord) < 0) {
						longestWord = word;
					}
				}
			}
			
			System.out.println(totalScore + " " + longestWord + " " + foundWords.size());
		}
	}
	
	public static void recursion(int y, int x, Node node) {
		if (node.isEnd) {
			foundWords.add(sb.toString());
		}
		
		if (sb.length() == 8) return;
		
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && ny < 4 && nx >= 0 && nx < 4 && !visited[ny][nx]) {
				int idx = board[ny][nx] - 'A';
				
				if (node.children[idx] != null) {
					visited[ny][nx] = true;
					sb.append(board[ny][nx]);
					
					recursion(ny, nx, node.children[idx]);
					
					sb.deleteCharAt(sb.length() - 1);
					visited[ny][nx] = false;
				}
			}
		}
	}
}