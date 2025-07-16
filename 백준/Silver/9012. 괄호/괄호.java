import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t=0; t<T; t++) {
            String target = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();

            boolean flag = true;

            for(int i=0; i<target.length(); i++) {
                if (target.charAt(i) == '(') {
                    stack.push(target.charAt(i));
                }
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
