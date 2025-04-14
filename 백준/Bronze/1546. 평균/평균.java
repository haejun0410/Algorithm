import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      
      Double [] scores = new Double[n];
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
      for (int i=0; i<n; i++) {
        scores[i] = Double.parseDouble(st.nextToken());
      }
      Arrays.sort(scores);
      
      Double maxScore = scores[n-1];
      
      Double sum = 0.0;
      
      for (int i=0; i<n; i++) {
        scores[i] = (scores[i] / maxScore)*100;
        sum += scores[i];
      }
      
      System.out.println(sum/n);
  }
}