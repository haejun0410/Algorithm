import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();

                clothes.put(category, clothes.getOrDefault(category, 0) + 1);
            }

            int answer = 1;

            for(Integer count : clothes.values()) {
                answer *= (count + 1);
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb.toString());
    }
}