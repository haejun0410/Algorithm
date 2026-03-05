import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isGoodWord(String word) {
        int len = word.length();
        
        if (len % 2 != 0) return false;

        char[] stack = new char[len];
        int top = -1;

        for (int i = 0; i < len; i++) {
            char cur = word.charAt(i);

            if (top >= 0 && stack[top] == cur) {
                top--;
            } 
            else {
                stack[++top] = cur;
            }
        }

        return top == -1;
    }
}