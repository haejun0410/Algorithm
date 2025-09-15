import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=n-1; i>=0; i--) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(arr[i]);
            }
            else {
                while(!stack.isEmpty() && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = -1;
                }
                else {
                    result[i] = stack.peek();
                }

                stack.push(arr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num: result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString());


    }
}
