import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '0' || c == '6' || c == '9') {
                    sb.append('9');
                } else {
                    sb.append(c);
                }
            }
            int converted = Integer.parseInt(sb.toString());
            if (converted > 100) converted = 100;
            scores[i] = converted;
            sum += converted;
        }
        
        double avg = (double) sum / N;
        int rounded = (int)Math.round(avg);
        
        System.out.println(rounded);
    }
}
