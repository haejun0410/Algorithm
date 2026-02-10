import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		if (nextPermutation(numbers)) {
			for(int i = 0; i < n; i++) {
				sb.append(numbers[i]).append(" ");
			}
		}
		else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	private static boolean nextPermutation(int[] p) {
		int i = p.length -1;
		while(i > 0 && p[i-1] >= p[i]) i--;
		if (i <= 0) return false;
		
		int j = p.length - 1;
		while(p[i-1] >= p[j]) j--;
		
		swap(p, i-1, j);
		
		int k = p.length - 1;
		while(i < k) {
			swap(p, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
