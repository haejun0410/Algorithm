import java.io.*;
import java.nio.LongBuffer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int n = Integer.parseInt(br.readLine());
        long answer = 0;
        Stack<Long[]> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            long temp = Long.parseLong(br.readLine());
            long cnt = 1;
            while(!stack.isEmpty() && stack.peek()[0] <= temp) {
                answer += stack.peek()[1];
                if (stack.peek()[0] == temp) {
                    cnt = stack.peek()[1] + 1;
                }
                else {
                    cnt = 1;
                }
                stack.pop();
            }

            if (!stack.isEmpty()) {
                answer++;
            }
            stack.add(new Long[] { temp, cnt});

        }

        System.out.println(answer);
	}
}