import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = 0;
      
      for (int i=3; i>0; i--) {
        String token = br.readLine();
        if (token.charAt(0) != 'F'&& token.charAt(0) != 'B') {
          n = Integer.parseInt(token) + i;
        }
      }
      
      StringBuilder sb = new StringBuilder();
      
      if (n % 3 == 0) {
        sb.append("Fizz");
      }
      if (n % 5 == 0) {
        sb.append("Buzz");
      }
      if (n % 3 != 0 && n % 5 != 0) {
        sb.append(n);
      }
      
      System.out.println(sb);
  }
}