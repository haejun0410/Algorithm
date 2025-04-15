import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[] scores = new int[n];
      
      for (int i=0; i<n; i++) {
        scores[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(scores);
      
      int exceptionNumber = (int)Math.round(n * 0.15);
      
      double sum = 0;
      
      for (int i=exceptionNumber; i<n-exceptionNumber; i++) {
        sum += scores[i];
      }
      
      System.out.println((int)Math.round(sum/(n-2*exceptionNumber)));
  }
}

