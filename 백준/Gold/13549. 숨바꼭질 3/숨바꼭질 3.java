import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] visited = new int[100001];
		Arrays.fill(visited, -1); 

		Deque<Integer> deque = new ArrayDeque<>();
		deque.offer(n);
		visited[n] = 0;

		while (!deque.isEmpty()) {
			int current = deque.poll();

			if (current * 2 <= 100000 && visited[current * 2] == -1) {
				visited[current * 2] = visited[current];
				deque.offerFirst(current * 2); 
			}

			if (current - 1 >= 0 && visited[current - 1] == -1) {
				visited[current - 1] = visited[current] + 1;
				deque.offerLast(current - 1); 
			}

			if (current + 1 <= 100000 && visited[current + 1] == -1) {
				visited[current + 1] = visited[current] + 1;
				deque.offerLast(current + 1);
			}
		}

		System.out.println(visited[m]);
    }
}
