import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int num;

            switch(command) {

                case 1:
                    num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                case 2:
                    num = Integer.parseInt(st.nextToken());
                    deque.addLast(num);
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                    sb.append("-1\n");
                    }
                        else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                    }
                    else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;

            }
        }

        System.out.println(sb.toString());
    }
}
