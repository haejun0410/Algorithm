import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] jewels = new int[n][2];
		int[] bags = new int[k];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			jewels[i][0] = w;
			jewels[i][1] = v;
		}

		for(int i=0; i<k; i++) {
			int w = Integer.parseInt(br.readLine());
			bags[i] = w;
		}

		Arrays.sort(bags);
		Arrays.sort(jewels, (o1, o2) -> {
			return o1[0] - o2[0];
			
		});

		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int j = 0;

		for(int i=0; i<k; i++) {
			int bagWeight = bags[i];

			while (j < n && jewels[j][0] <= bagWeight) {
				pq.offer(jewels[j][1]);
				j++;
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		
		System.out.println(answer);
    }
}
