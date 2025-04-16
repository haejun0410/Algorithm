import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            hash1.put(i+1, s);
            hash2.put(s, i+1);
        }

        for (int i=0; i<m; i++) {
            String s = br.readLine();
            if (49 <= s.charAt(0) && s.charAt(0) <= 57) {
                sb.append(hash1.get(Integer.parseInt(s))).append("\n");
            }
            else {
                sb.append(hash2.get(s)).append("\n");
            }
        }

        System.out.println(sb);

    }
}
