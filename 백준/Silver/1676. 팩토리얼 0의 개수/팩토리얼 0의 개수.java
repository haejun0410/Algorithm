import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      int cnt2 = 0;
      int cnt5 = 0;
      
      for (int i=1; i<=n; i++) {
        int num = i;
        while (num!= 0 && num%2 == 0) {
          cnt2++;
          num = num/2;
        }
        num = i; 
        while (num!= 0 && num%5==0) {
          cnt5++;
          num = num/5;
        }
      }
      
      System.out.println(Math.min(cnt2, cnt5));
  }
}