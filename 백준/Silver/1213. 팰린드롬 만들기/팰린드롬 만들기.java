import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int[] alpha = new int[26];

        for (int i=0; i<s.length(); i++) {
            int idx = s.charAt(i)-'A';
            alpha[idx]++;
        }

        int isOne = 0;
        int oneIdx = 0;
        for (int i=0; i<alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                isOne++;
                oneIdx = i;
            }
        }

        String answer = "";
        StringBuilder sb = new StringBuilder();
        if (isOne>1) {
            answer += "I'm Sorry Hansoo";
        }
        else {
            for (int i=0; i<alpha.length; i++) {
                for (int r=0; r<alpha[i]/2; r++) {
                    sb.append((char)(i+65));
                }
            }
            answer += sb.toString();
            if (isOne == 1) {
                answer += (char)(oneIdx+65);
            }
            String end = sb.reverse().toString();
            answer += end;
        }

        System.out.println(answer);
    }
}
