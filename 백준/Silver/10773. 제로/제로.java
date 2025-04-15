import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int k = Integer.parseInt(br.readLine());
      
      Stack<Integer> stack = new Stack<>();
      
      for (int i=0; i<k; i++) {
        int number = Integer.parseInt(br.readLine());
        if (number != 0) {
          stack.push(number);
        }
        else {
          stack.pop();
        }
      }
      
      int sum = 0;
      while (!stack.isEmpty()) {
        sum += stack.pop();
      }
      
      System.out.println(sum);

  }
}