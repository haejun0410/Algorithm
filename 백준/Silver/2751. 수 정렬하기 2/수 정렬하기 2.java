import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      boolean[] arr = new boolean[2000001];
      
      for (int i=0; i<n; i++) {
        arr[1000000+Integer.parseInt(br.readLine())] = true;
      }
      
      StringBuilder sb = new StringBuilder();
      
      for (int i=0; i<arr.length; i++) {
        if (arr[i]) {
          sb.append(i-1000000).append("\n");
        }
      }
      
      System.out.println(sb);
  }
}