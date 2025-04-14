import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      
      System.out.println(nCr(n,k));
  }
  
  public static int nCr(int n, int k) {
    int answer = fact(n) / (fact(k)*fact(n-k));
    return answer;
  }
  
  public static int fact(int n){
    int result = 1;
    for (int i=2; i<=n; i++) {
      result *= i;
    }
    return result;
  }
}