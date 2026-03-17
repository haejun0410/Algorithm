import java.util.*;
import java.io.*;

public class Main {
	
	public static class Problem implements Comparable<Problem>{
		int num;
		int level;
		
		Problem(int num, int level) {
			this.num = num;
			this.level = level;
		}
		
		@Override
		public int compareTo(Problem o) {
			if (this.level != o.level) return o.level - this.level;
			return o.num - this.num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문제 수
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<Problem> set = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			
			set.add(new Problem(num, level));
			map.put(num, level);
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			if (command.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				int level = Integer.parseInt(st.nextToken());
				
				set.add(new Problem(num, level));
				map.put(num, level);
			}
			else if (command.equals("recommend")) {
				int mode = Integer.parseInt(st.nextToken());
				Problem p;
				// 어려운거, 번호 큰거
				if (mode == 1) {
					p = set.first();
				}
				// 쉬운거, 번호 낮은거
				else {
					p = set.last();
				}
				sb.append(p.num).append("\n");
			}
			else if (command.equals("solved")) {
				int num = Integer.parseInt(st.nextToken());
				int level = map.get(num);
				
				set.remove(new Problem(num, level));
			}
		}
		
		System.out.println(sb);
	}
}