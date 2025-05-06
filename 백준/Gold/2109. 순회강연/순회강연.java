import java.io.*;
import java.util.*;

public class Main {

	static class schedule implements Comparable<schedule> {

		int p,d;

		public schedule (int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(schedule o) {
			if (this.p == o.p) {
				return o.d - this.d;
			}
			return o.p - this.p;
		}

	}
	static int n;
	static int max = -1;
	static int answer = 0;
	static PriorityQueue<schedule> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			max = Math.max(max, d);
			pq.add(new schedule(p, d));
		}

		boolean[] check = new boolean[max+1];

		while (!pq.isEmpty()) {
			schedule current = pq.poll();

			for (int i=current.d-1; i>=0; i--) {
				if (!check[i]) {
					check[i] = true;
					answer += current.p;
					break;
				}
			}
		}

		System.out.println(answer);
	}
}