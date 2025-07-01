import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('1', 0);
        map.put('0', 0);

        char cur = word.charAt(0);

        for(int i = 1; i < word.length(); i++) {
            char next = word.charAt(i);
            if (cur != next) {
                map.put(cur, map.get(cur) + 1);
                cur = next;
            }
        }
        map.put(cur, map.get(cur) + 1);

        System.out.println(Math.min(map.get('0'), map.get('1')));
    }
}