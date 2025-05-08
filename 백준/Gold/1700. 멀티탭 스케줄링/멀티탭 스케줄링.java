import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int answer = 0;
		boolean[] activated = new boolean[k+1];
		List<Integer> multitap = new ArrayList<>();


		st = new StringTokenizer(br.readLine());
		int[] arr = new int[k];

		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<k; i++) {

			int num = arr[i];
			
			// 멀티탬에 구멍이 남아있음
			if (cnt < n) {
				// 기존에 꽂지 않았던 거라면 꽂고 cnt++
				if (!activated[num]) {
					activated[num] = true;
					multitap.add(num);
					cnt++;
				}
			}

			// 멀티탭에 구멍이 없음. 
			else if (!activated[num]) {
				int idxToRemove = -1;
				int farthestUse = -1;

				for(int j=0; j<multitap.size(); j++) {
					int plug = multitap.get(j);
					int nextUse = Integer.MAX_VALUE;

					for(int l = i+1; l<k; l++) {
						if (arr[l] == plug) {
							nextUse = l;
							break;
						}
					}
					// 가장 나중에 오는 번호로 갱신( 앞으로 사용하지 않는 기기는 가장 큰 수임)
					if (nextUse > farthestUse) {
						farthestUse = nextUse;
						idxToRemove = j;
					}
				}

				int removed = multitap.get(idxToRemove);
				activated[removed] = false;
				multitap.remove(idxToRemove);

				multitap.add(num);
				activated[num] = true;
				cnt++;
				answer++;
			}

		}
		System.out.println(answer);
    }
}
