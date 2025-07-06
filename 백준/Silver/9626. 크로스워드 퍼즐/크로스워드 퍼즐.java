import java.io.*;
import java.util.*;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		int U = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		char arr[][] = new char[M + U + D][N + L + R];

		for (int i = 0; i < M; i++) {
			String str = bf.readLine();

			for (int j = 0; j < N; j++) {
				arr[U + i][L + j] = str.charAt(j);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != '\0') {
					bw.write(arr[i][j]);
				} else if (i % 2 == 0) {
					if (j % 2 == 0) {
						bw.write("#");
					} else {
						bw.write(".");
					}
				} else {
					if (j % 2 == 0) {
						bw.write(".");
					} else {
						bw.write("#");
					}
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}