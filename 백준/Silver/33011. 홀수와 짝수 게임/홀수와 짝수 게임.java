import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테스트케이스 입력
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int oddCnt = 0; // 홀수 갯수
			int evenCnt = 0;// 짝수 갯수
			int arr[] = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());// 카드 입력받기
				if (arr[i] % 2 == 0)
					evenCnt++;
				else
					oddCnt++;
			}
			int maxCnt = Math.max(oddCnt, evenCnt); //더 많은 카드더미 찾기
			
			if ((oddCnt != evenCnt) && maxCnt % 2 != 0) {
				System.out.println("amsminn");//채완 승
			} else {
				System.out.println("heeda0528");//희원 승
			}
		}
	}
}
