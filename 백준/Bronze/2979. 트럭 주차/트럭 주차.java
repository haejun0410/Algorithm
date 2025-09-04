import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] costs = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<4; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] time = new int[101];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            time[Integer.parseInt(st.nextToken())] += 1;
            time[Integer.parseInt(st.nextToken())] -= 1;
        }

        int totalCost = 0;

        for(int i=1; i<101; i++) {
            time[i] = time[i-1] + time[i];
            totalCost += time[i] * costs[time[i]];
        }

        System.out.println(totalCost);

    }

}
