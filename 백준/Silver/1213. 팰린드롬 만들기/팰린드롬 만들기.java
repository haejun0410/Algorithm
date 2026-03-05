import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] countAlphabet = new int[26];

        for (int i = 0; i < word.length(); i++) {
            countAlphabet[word.charAt(i) - 'A']++;
        }

        int cntOdd = 0;
        int index = -1;
        StringBuilder sb = new StringBuilder();
        char odd = ' ';
        for (int i = 0; i < 26; i++) {
            int cnt = countAlphabet[i];
            if (cnt != 0) {
                char ch = (char)(i + 'A');
                if (cnt % 2 == 1) {
                    cntOdd++;
                    index = i;
                }

                for (int j = 0; j < cnt/2; j++) {
                    sb.append(ch);
                }
            }

        }
        StringBuilder reverseSb = new StringBuilder(sb).reverse();
        String answer;
        if (cntOdd > 1) {
            answer = "I'm Sorry Hansoo";
        }
        else {
            if (cntOdd == 1) {
                sb.append((char)(index + 'A'));
            }
            answer = sb.toString() + reverseSb.toString();
        }

        System.out.println(answer);
    }
}