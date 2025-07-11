import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> map = new HashSet<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                map.add(name);
            }
            else {
                map.remove(name);
            }
        }

        List<String> list = new ArrayList<>(map);
        Collections.sort(list, Collections.reverseOrder());

        for(String name : list) {
            System.out.println(name);
        }
    }
}