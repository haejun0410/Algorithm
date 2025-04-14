import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      for (int i=0; i<n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(a);
      
      int m = Integer.parseInt(br.readLine());
      
      st = new StringTokenizer(br.readLine());
      for (int i=0; i<m ; i++) {
        if (find(a, Integer.parseInt(st.nextToken()))) {
          System.out.println("1");
        }  
        else {
          System.out.println("0");
        }
      }
  }
  
  public static boolean find(int[] arr, int target) {
    int start = 0;
    int end = arr.length -1;
    int mid = 0;
    
    while (start <= end) {
      mid = (start + end) / 2;
      
      if (arr[mid] > target) {
        end = mid-1;
      }
      else if (arr[mid] < target) {
        start = mid+1;
      }
      else {
        return true;
      }
    }
    
    return false;
  }
}