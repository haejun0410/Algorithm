import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('-', 0);
        map.put('\\', 1);
        map.put('(', 2);
        map.put('@', 3);
        map.put('?', 4);
        map.put('>', 5);
        map.put('&', 6);
        map.put('%', 7);
        map.put('/', -1);


        for(;;) {
            String line = br.readLine();

            if (line.equals("#")) break;

            int answer = 0;
            int length = line.length() -1;
            for(int i=0; i<=length; i++) {
                answer += map.get(line.charAt(i)) * (int)Math.pow(8, (length - i));
            }

            System.out.println(answer);
        }

    }

}
