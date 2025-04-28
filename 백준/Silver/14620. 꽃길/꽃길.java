import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[][] garden;
	static int[][] seed;

	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, -1, 0, 1};

	static int cost = 2147483647;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
		garden = new int[n][n];
		seed = new int[n][n];

		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				garden[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backtracking(0);

		System.out.println(cost);

    }

	public static void calculate() {
		int answer = 0;

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (seed[i][j] == 1) {
					answer += garden[i][j];
				}
			}
		}
		cost = Math.min(cost, answer);

	}

	public static void backtracking(int count) {
		if (count == 3) {
			calculate();
			return;
		}

		for(int i=1; i<n-1; i++) {
			for(int j=1; j<n-1; j++) {
				if (seed[i][j] == 0) {
					if (!makeFlower(i, j)) {
						unFlower(i, j);
						continue;
					}
					backtracking(count+1);
					unFlower(i, j);
				}
			}
		}
	}

	public static boolean makeFlower(int y, int x) {
		boolean flag = true;
		for(int i=0; i<5; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
				
			seed[ny][nx]++;
			if (seed[ny][nx] > 1) {
				flag = false;
			}
		}
		

		return flag;
	}

	public static void unFlower(int y, int x) {
		for(int i=0; i<5; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			seed[ny][nx]--;
		}
	}


}
