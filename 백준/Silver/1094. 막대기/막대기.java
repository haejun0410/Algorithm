import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> sticks = new ArrayList<>();
        sticks.add(64);
        int sum = 64;

        int goal = Integer.parseInt(br.readLine());

        for(;;) {
            if (sum == goal) {
                System.out.println(sticks.size());
                return;
            }
            Collections.sort(sticks);

            // 가장 짧은 막대기 추출
            int shortStick = sticks.remove(0);
            int restLength = sum - shortStick;

            if (restLength + shortStick/2 >= goal) {
                sticks.add(shortStick/2);
                sum = restLength + shortStick/2;
            }
            else {
                sticks.add(shortStick/2);
                sticks.add(shortStick/2);
            }
        }
    }
    
}
