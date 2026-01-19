import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gifts.offer(Integer.parseInt(st.nextToken()));
        }

        int[] wants = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            wants[i] = Integer.parseInt(st.nextToken());
        }


        boolean flag = true;

        for(int want : wants) {
            int current = gifts.poll();
            if (current >= want) {
                current -= want;
                gifts.offer(current);
            }
            else {
                flag = false;
            }
        }

        if (flag){
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }


    }
}
