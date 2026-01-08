import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String word = br.readLine();
            for(int i=0; i<word.length(); i++) {
                sb.append(affineCipher(a, b, word.charAt(i)));
            }
            sb.append("\n");

        }

        System.out.println(sb.toString());
    }

    public static String affineCipher(int a, int b, Character c) {
        int index = c - 'A';
        int cipher = (a*index + b) % 26;
        return Character.toString((char)(cipher + 'A'));
    }
}
