import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] index = new Integer[n];
        int[] solved = new int[n];
        int[] penalties = new int[n];
        for(int i=0; i<n; i++) {
            index[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            solved[i] = Integer.parseInt(st.nextToken());
            penalties[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(index, (o1, o2) -> {
            if (solved[o1] != solved[o2]) {
                return solved[o2] - solved[o1];
            }
            return penalties[o1] - penalties[o2];
        });

        int answer = 0;

        for(int i=4; i<n; i++) {
            if (solved[index[i]] == solved[index[4]]) answer++;
        }

        System.out.println(answer-1);



    }
}
