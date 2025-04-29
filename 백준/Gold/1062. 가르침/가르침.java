import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int[] word;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k < 5) {
            System.out.println(0);
            return;
        }

        word = new int[n];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++) {
                word[i] = (word[i] | (1 << (str.charAt(j) - 'a')));
            }
        }
        int bit = 0;
        bit = (bit | (1 << ('a' - 'a')));
        bit = (bit | (1 << ('n' - 'a')));
        bit = (bit | (1 << ('t' - 'a')));
        bit = (bit | (1 << ('i' - 'a')));
        bit = (bit | (1 << ('c' - 'a')));

        comb(0,5, bit);
        System.out.println(answer);
    }

    public static void comb(int idx, int cnt, int bit) {
        if (cnt == k) {
            count(bit);
            return;
        }
        if (idx == 26) {
            return;
        }
        if (idx == ('a'-'a') || idx == ('n'-'a') || idx == ('t'-'a') || idx == ('i'-'a')) {
            comb(idx+1, cnt, bit);
        }
        else {
            comb(idx+1, cnt+1, (bit | (1 << idx)));
            comb(idx+1, cnt, bit);
        }
        
    }

    public static void count(int bit) {
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (word[i] == (word[i] & bit)) {
                cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
    
}