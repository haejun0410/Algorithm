import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i=0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    if (num == 1) {
                        int max = map.lastKey();
                        if (map.get(max) == 1) {
                            map.remove(max);
                        } else {
                            map.put(max, map.get(max) - 1);
                        }
                    } else if (num == -1) {
                        int min = map.firstKey();
                        if (map.get(min) == 1) {
                            map.remove(min);
                        } else {
                            map.put(min, map.get(min) - 1);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}