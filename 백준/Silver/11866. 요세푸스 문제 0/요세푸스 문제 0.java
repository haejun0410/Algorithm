import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      Queue<Integer> queue = new LinkedList<>();
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      StringBuilder sb = new StringBuilder();
      
      sb.append("<");
      
      for (int i=1; i<=n; i++) {
        queue.add(i);
      }
      
      while (queue.size() > 1) {
        for (int i=0; i<k-1; i++) {
          queue.offer(queue.poll());
        }
        
        sb.append(queue.poll()).append(", ");
      }
      sb.append(queue.poll()).append(">");
      
      System.out.println(sb);
  }
}

