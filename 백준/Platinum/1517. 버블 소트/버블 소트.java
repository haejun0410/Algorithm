import java.util.*;
import java.io.*;

public class Main {
	static long[] tree;
	
	static void update(int i, long diff, int n) {
		while(i <= n) {
			tree[i] += diff;
			i += (i & -i);
		}
	}
	
	static long prefixSum(int i) {
		long result = 0;
		while(i > 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] temp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			temp[i] = arr[i];
		}
		
		Arrays.sort(temp);
		int[] uniqueArr = new int[n];
		int uniqueCount = 0;
		
		uniqueArr[uniqueCount++] = temp[0];
		for (int i = 1; i < n; i++) {
			if (temp[i] != temp[i-1]) {
				uniqueArr[uniqueCount++] = temp[i];
			}
		}
		
		tree = new long[uniqueCount + 1];
		long totalSwaps = 0;
		
		for (int i = 0; i < n; i++) {
			int rank = Arrays.binarySearch(uniqueArr, 0, uniqueCount, arr[i]) + 1;
			
			long largerCount = prefixSum(uniqueCount) - prefixSum(rank);
			totalSwaps += largerCount;
			
			update(rank, 1, uniqueCount);
		}
		
		System.out.print(totalSwaps);
		
	}
}