import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      int num1 = Integer.parseInt(st.nextToken());
      int num2 = Integer.parseInt(st.nextToken());
      
      int minValue = Math.min(num1, num2);
      int maxValue = Math.max(num1, num2);
      
      int gcd = gcd(minValue, maxValue);
      int lcm = (num1 * num2) / gcd;
      
      System.out.println(gcd);
      System.out.println(lcm);
  }
  
  private static int gcd(int a, int b){
    int r = 0;
    
    while (b != 0) {
      r = a%b;
      a = b;
      b = r;
    }
    
    return a;
  }
}
