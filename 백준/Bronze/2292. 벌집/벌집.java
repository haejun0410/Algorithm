import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      int count = 1;
      int range = 2;
      
      if (n == 1){
        System.out.println(1);
      }
      else {
        while (range <= n) {
          range = range + (6*count);
          count++;
        }
        System.out.println(count);
      }
      
      
  }
}