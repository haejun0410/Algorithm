import java.io.*;
import java.util.*;

public class Main {
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String arr = br.readLine();
		System.out.println(descending(arr));
		System.out.println(ascending(arr));
	}

	public static String ascending(String arr) {
		String answer = "";
		String temp = "0";
		int current = 0;
		StringTokenizer st = new StringTokenizer(arr);
		for(int i=0; i<k; i++) {
			String chr = st.nextToken();
			if (chr.equals("<")) {
				answer += temp;
				current++;
				if (current <= 9) {
					temp = String.valueOf(current);
				}
				else {
					temp = "";
				}
			}
			else {
				current++;
				temp = String.valueOf(current) + temp;
			}
		}
		return answer + temp;
	}

	public static String descending(String arr) {
		String answer = "";
		String temp = "9";
		int current = 9;
		StringTokenizer st = new StringTokenizer(arr);
		for (int i=0; i<k; i++) {
			String chr = st.nextToken();
			if (chr.equals(">")) {
				answer += temp;
				current--;
				if (current >= 0) {
					temp = String.valueOf(current);
				}
				else {
					temp = "";
				}
				
			}
			else {
				current--;
				temp = String.valueOf(current) + temp;
			}
		}

		return answer + temp;
	}
}
