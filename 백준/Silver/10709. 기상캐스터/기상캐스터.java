import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		Character[][] map = new Character[h][w];
		int[][] time = new int[h][w];

		for (int i=0; i<h; i++) {
			Arrays.fill(time[i], -1);
		}

		for (int i=0; i<h; i++) {
			String arr = br.readLine();

			for (int j=0; j<w; j++) {
				map[i][j] = arr.charAt(j);
				if (arr.charAt(j) == 'c') {
					time[i][j] = 0;
				}
			}
		}

		for (int r=0; r<w-1; r++) {
			for (int i=0; i<h; i++) {
				for (int j=w-1; j>0; j--) {
					map[i][j] = map[i][j-1];
				}
				map[i][0] = '.';
			}

			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (time[i][j] == -1 && map[i][j] == 'c') {
						time[i][j] = time[i][j-1] + 1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				sb.append(time[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
	
}