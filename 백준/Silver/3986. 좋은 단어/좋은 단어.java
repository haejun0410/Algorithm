import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for (int idx = 0; idx < word.length(); idx++) {
                char ch = word.charAt(idx);

                if (stack.size() == 0 || stack.peek() != ch) {
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
            }

            answer += (stack.size() == 0 ? 1 : 0);
        }

        System.out.println(answer);
    }
}