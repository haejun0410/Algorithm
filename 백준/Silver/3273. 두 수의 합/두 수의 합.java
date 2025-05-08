import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int target = Integer.parseInt(br.readLine());

		int start = 0;
		int end = arr.length-1;

		int cnt = 0;

		while (start < end) {
			int temp = arr[start] + arr[end];

			if (temp < target) {
				start++;
			}
			else if (temp > target) {
				end--;
			}
			else {
				cnt++;
				start++;
			}
		}

		System.out.println(cnt);

		
    }
}
