import java.io.*;
import java.util.*;

public class Main {

	static class time implements Comparable<time> {
		int arrival, duration;

		public time (int arrival, int duration) {
			this.arrival = arrival;
			this.duration = duration;
		}

		@Override
		public int compareTo(time o) {
			return this.arrival-o.arrival  ;
		}
	}

	static PriorityQueue<time> pq = new PriorityQueue<>();
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int arrival = Integer.parseInt(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());

			pq.add(new time(arrival, duration));
		}

		int time = 0;

		for(int i=0; i<n; i++) {
			time cur = pq.poll();
			if (time < cur.arrival) {
				time = cur.arrival;
				time += cur.duration;
			}
			else {
				time += cur.duration;
			}
		}


		System.out.println(time);
        
    }
}
