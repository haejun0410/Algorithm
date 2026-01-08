import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long sumTime = (n - 1) * 8;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sumTime += Integer.parseInt(st.nextToken());
		}
		
		sb.append(sumTime / 24).append(" ").append(sumTime % 24);
		
		System.out.println(sb.toString());
	}
}
