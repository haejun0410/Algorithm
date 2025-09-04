import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphaCount = new int[26];

        String word = br.readLine();
        for(int i=0; i<word.length(); i++) {
            alphaCount[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append(alphaCount[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

}
