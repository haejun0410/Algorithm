import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			map.clear();
			
			for (int i = 0 ; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String command = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				
				if (command.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
					count++;
				}
				else {
					if (count == 0) continue;
					int target = (num == 1 ? map.lastKey() : map.firstKey());
					
					if (map.get(target) == 1) {
						map.remove(target);
					}
					else {
						map.put(target, map.get(target) -1);
					}
					count--;
				}
			}
			
			if (count == 0) {
				sb.append("EMPTY").append("\n");
			}
			else if (count == 1) {
				sb.append(map.lastKey()).append(" ").append(map.lastKey()).append("\n");
			}
			else{
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}
}