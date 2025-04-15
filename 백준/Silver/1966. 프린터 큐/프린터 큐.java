import java.util.*;
import java.io.*;

public class Main {
    
    public static boolean[] prime;
  
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int test_case  = Integer.parseInt(br.readLine());
      
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      for (int t=0; t<test_case; t++) {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        LinkedList<int[]> queue = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=0; i<n; i++) {
          queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
        }
        
        int count = 0;
        
        while (!queue.isEmpty()) {
          
          int[] front = queue.poll();
          boolean isMax = true;
          
          for (int i=0; i<queue.size(); i++) {
            if(front[1] < queue.get(i)[1]) {
              queue.offer(front);
              for (int j=0; j<i; j++) {
                queue.offer(queue.poll());
              }
              
              isMax = false;
              break;
            }
          }
          if (isMax == false) {
            continue;
          }
          
          count++;
          if (front[0] == m) {
            break;
          }
        }
        sb.append(count).append("\n");
      }
      System.out.println(sb);
  }
}

