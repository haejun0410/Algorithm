import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            String word = br.readLine();
            if (word.length() % 2 != 0) continue;

            Deque<Character> stack = new ArrayDeque<>();
            for (char ch : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}