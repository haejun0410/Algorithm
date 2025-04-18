import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(br.readLine());

		int currentPos = 0;
		int sum = 0;

		for (int i=0; i<j; i++) {
			int pos = Integer.parseInt(br.readLine()) - 1;
			int newPos = move(currentPos, pos);
			sum += Math.abs(newPos - currentPos);
			currentPos = newPos;
		}

		System.out.println(sum);
	}

	public static int move(int currentPos, int pos) {
		while (currentPos < pos && currentPos + m -1 < pos) {
			currentPos++;
		}
		while (currentPos > pos && currentPos + m -1 > pos) {
			currentPos--;
		}
		return currentPos;
	}

	
}