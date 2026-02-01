import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] f = new int[10];
        int[] f_inv = new int[10];
        
        for (int i = 0; i < 10; i++) {
            f[i] = Integer.parseInt(st.nextToken());
            f_inv[f[i]] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        String fA_str = st.nextToken();
        String fB_str = st.nextToken();
        
        long A = restore(fA_str, f_inv);
        long B = restore(fB_str, f_inv);
        
        long sum = A + B;
        System.out.println(convert(sum, f));
    }
    
    private static long restore(String s, int[] f_inv) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            res.append(f_inv[c - '0']);
        }
        return Long.parseLong(res.toString());
    }
    
    private static String convert(long num, int[] f) {
        String s = String.valueOf(num);
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            res.append(f[c - '0']);
        }
        return res.toString();
    }
}