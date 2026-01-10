import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String word1 = br.readLine();
        String word2 = br.readLine();

        if (check1(word1, word2) && check2(word1, word2) &&  check3(word1, word2)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

    }

    // 한 단어를 재배열해 다른 단어를 만들 수 있어야 한다.
    public static boolean check1(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[word1.charAt(i) - 'a']++;
            cnt[word2.charAt(i) - 'a']--;
        }
        for (int v : cnt) {
            if (v != 0) return false;
        }
        return true;

    }

    // 두 단어의 첫 글자와 마지막 글자는 서로 동일해야 한다.
    public static boolean check2(String word1, String word2) {
        return ((word1.charAt(0) == word2.charAt(0)) && (word1.charAt(n-1) == word2.charAt(n-1)));
    }

    // 각 단어에서 모음(a, e, i, o, u)을 제거한 문자열은 동일해야 한다.
    public static boolean check3(String word1, String word2) {

        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<n; i++) {
            if (word1.charAt(i) != 'a' &&
                    word1.charAt(i) != 'e' &&
                    word1.charAt(i) != 'i' &&
                    word1.charAt(i) != 'o' &&
                    word1.charAt(i) != 'u') {
                sb1.append(word1.charAt(i));
            }
        }

        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<n; i++) {
            if (word2.charAt(i) != 'a' &&
                    word2.charAt(i) != 'e' &&
                    word2.charAt(i) != 'i' &&
                    word2.charAt(i) != 'o' &&
                    word2.charAt(i) != 'u') {
                sb2.append(word2.charAt(i));
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}
