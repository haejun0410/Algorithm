import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase=0; testCase<t; testCase++) {
			int num = Integer.parseInt(br.readLine());
			int cnt = 0;

			int index = 1;

			for(;;) {
				int tempCnt = (int)(num / (Math.pow(5, index)));

				if (tempCnt == 0) break;
				else {
					cnt += tempCnt;
					index++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
	
}
