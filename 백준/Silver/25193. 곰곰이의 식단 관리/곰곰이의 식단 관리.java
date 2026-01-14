import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int[] alphabet = new int[26];

        for (int i = 0; i < n; i++) {
            alphabet[word.charAt(i) - 'A']++;
        }

        int chickenCount = alphabet['C' - 'A'];
        int elseCount = n - chickenCount;

        int answer;

        if (elseCount == 0) {
            answer = chickenCount;
        } else {
            answer = (chickenCount + (elseCount + 1) - 1) / (elseCount + 1);
        }

        System.out.println(answer);
    }
}
