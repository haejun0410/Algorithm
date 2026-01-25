import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int student = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> order = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < student; i++) {
            int n = Integer.parseInt(st.nextToken());
            order.add(i - n, i + 1);
        }

        for (int i : order) {
            System.out.print(i + " ");

        }
    }
}
