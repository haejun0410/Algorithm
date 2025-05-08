import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] time = new int[n][2];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			time[i][0] = start;
			time[i][1] = end;
		}

		Arrays.sort(time, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}return o1[1] - o2[1];
		});

		int numRoom = 1;
		int endTime = time[0][1];

		for(int i=1; i<n; i++) {
			if (time[i][0] >= endTime) {
				numRoom++;
				endTime = time[i][1];
			}
		}

		System.out.println(numRoom);


    }
}
