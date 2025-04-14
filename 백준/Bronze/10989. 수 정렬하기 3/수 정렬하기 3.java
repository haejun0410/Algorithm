import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      int[] counter = new int[100001];
      for (int i=0; i<n; i++) {
        counter[Integer.parseInt(br.readLine())]++;
      }
      br.close();
      
      StringBuilder sb = new StringBuilder();
      
      for (int i=0; i<10001; i++) {
        if (counter[i] != 0) {
          for (int j=0; j<counter[i]; j++) {
            sb.append(i).append("\n");
          }
        }
      }
      
      System.out.println(sb);
  }
}