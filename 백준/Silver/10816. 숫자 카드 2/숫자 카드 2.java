import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      int[] count = new int[20000001];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i=0; i<n; i++) {
        count[Integer.parseInt(st.nextToken()) + 10000000]++;
      }
      
      int m = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      
      StringBuilder sb = new StringBuilder();
      
      for (int i=0; i<m; i++) {
        int num = Integer.parseInt(st.nextToken());
        sb.append(count[num + 10000000]).append(" ");
      }
      
      System.out.println(sb);

  }
}