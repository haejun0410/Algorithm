import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        String str;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int sex =  Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            String distinction = Integer.toString(sex) + Integer.toString(grade);
            map.put(distinction, map.getOrDefault(distinction, 0) + 1);
        }

        int answer = 0;
        for(int num: map.values()) {
            answer += (num + k -1 ) / k;
        }
        System.out.println(answer);
    }
}
