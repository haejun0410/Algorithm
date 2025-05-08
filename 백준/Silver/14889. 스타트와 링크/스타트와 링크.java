import java.io.*;
import java.util.*;

public class Main {

	static boolean[] selected;
	static int n;
	static int[][] board;
	static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		selected = new boolean[n];
		backtracking(0, 0);

		System.out.println(answer);

    }

	public static void backtracking(int idx, int cnt) {
		if (idx == n) return;

		if (cnt == n/2){
			answer = Math.min(answer, calculate());
		}

		selected[idx] = true;
		backtracking(idx+1, cnt+1);
		selected[idx] = false;
		backtracking(idx+1, cnt);

		// for(int i=idx; i<n; i++) {
		// 	selected[i] = true;
		// 	backtracking(i+1, cnt+1);
		// 	selected[i] = false;
		// }

	}

	public static int calculate() {
		int team1 = 0;
		int team2 = 0;

		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if (selected[i] && selected[j]) {
					team1 += board[i][j];
					team1 += board[j][i];
				}
				else if (!selected[i] && !selected[j]) {
					team2 += board[i][j];
					team2 += board[j][i];
				}
			}
		}

		return Math.abs(team1 - team2);
	}
}

