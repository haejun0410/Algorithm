import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] count = new int[26];

        for (char c : word.toCharArray()) {
            count[c - 'A']++;
        }

        int oddCount = 0;
        char center = ' ';
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                center = (char) (i + 'A');
            }
            
            // 절반만큼 미리 추가 (사전순 보장)
            for (int j = 0; j < count[i] / 2; j++) {
                prefix.append((char) (i + 'A'));
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder answer = new StringBuilder(prefix);
            if (oddCount == 1) answer.append(center);
            answer.append(prefix.reverse());
            System.out.println(answer);
        }
    }
}