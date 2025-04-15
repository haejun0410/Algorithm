import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int k = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[k];
      
      long start = 1;
      long end = 0;
      long answer = 0;
      
      for (int i=0; i<k; i++) {
        arr[i] = Integer.parseInt(br.readLine());
        end = Math.max(arr[i], end);
      }
      
      
      
      while (start <= end) {
        long len = (start + end)/2;
        long count = 0;
        
        for (int i=0; i<k; i++) {
          count += arr[i] / len;
        }
        
        if (count < n) {
          end = len -1;
        }
        else {
          start = len +1;
          if (len > answer) {
            answer = len;
          }
        }
      }
      
      System.out.println(answer);
  }
}