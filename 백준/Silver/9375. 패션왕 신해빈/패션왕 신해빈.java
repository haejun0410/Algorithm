import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String category = st.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int ret = 1;
            for(int val : map.values()) {
                ret *= (val+1);
            }

            System.out.println(ret-1);
        }
    }
}
