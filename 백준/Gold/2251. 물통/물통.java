import java.io.*;
import java.util.*;

public class Main {

    static int a,b,c;
    static Set<Integer> set;
    static boolean[][][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] initStatus = new int[] {0, 0, c};
        set = new HashSet<>();
        
        visited = new boolean[201][201][201];

        simulate(initStatus);

        List<Integer> result = new ArrayList<>(set);
        Collections.sort(result);

        for(int r : result) {
            System.out.print(r + " ");
        }

    }

    public static void simulate(int[] status) {

        if (visited[status[0]][status[1]][status[2]]) return;
        visited[status[0]][status[1]][status[2]] = true;

        if (status[0] == 0) {
            set.add(status[2]);
        }

        visited[status[0]][status[1]][status[2]] = true;

        for(int i=0; i<6; i++) {
            int[] temp = status.clone();
            switch(i) {
                // A -> B
                case 0 : 
                    int sum = temp[0] + temp[1];
                    if (sum >= b) {
                        temp[1] = b;
                        temp[0] = sum-b;
                    }
                    else {
                        temp[1] = sum;
                        temp[0] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;
                // A -> C               
                case 1 : 
                    sum = temp[0] + temp[2];
                    if (sum >= c) {
                        temp[2] = c;
                        temp[0] = sum-c;
                    }
                    else {
                        temp[2] = sum;
                        temp[0] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;
                // B -> A               
                case 2 : 
                    sum = temp[1] + temp[0];
                    if (sum >= a) {
                        temp[0] = a;
                        temp[1] = sum-a;
                    }
                    else {
                        temp[0] = sum;
                        temp[1] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;
                // B -> C               
                case 3 : 
                    sum = temp[1] + temp[2];
                    if (sum >= c) {
                        temp[2] = c;
                        temp[1] = sum-c;
                    }
                    else {
                        temp[2] = sum;
                        temp[1] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;
                // C -> A
                case 4 : 
                    sum = temp[2] + temp[0];
                    if (sum >= a) {
                        temp[0] = a;
                        temp[2] = sum-a;
                    }
                    else {
                        temp[0] = sum;
                        temp[2] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;
                // C -> B               
                case 5 :    
                    sum = temp[2] + temp[1];
                    if (sum >= b) {
                        temp[1] = b;
                        temp[2] = sum-b;
                    }
                    else {
                        temp[1] = sum;
                        temp[2] = 0;
                    }
                    if (!visited[temp[0]][temp[1]][temp[2]]) {
                        simulate(temp);
                    }
                    break;           

            }
        }
    }
}
