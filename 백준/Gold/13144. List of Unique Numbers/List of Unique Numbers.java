import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] count = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		long answer = 0;

		while (end < n) {
			if (count[arr[end]] == 0) {
				count[arr[end]]++;
				answer += (end - start + 1);
				end++;
			}
			else {
				count[arr[start]]--;
				
				start++;
				
			}
		}

		System.out.println(answer);

		
    }
}
