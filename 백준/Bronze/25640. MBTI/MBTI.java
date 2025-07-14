import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      String myMBTI = br.readLine();
      
      HashMap<String, Integer> map = new HashMap<>();
      
      int n = Integer.parseInt(br.readLine());
      
      for(int i=0; i<n; i++) {
        String temp = br.readLine();
        map.put(temp, map.getOrDefault(temp, 0) + 1);
      }
      
      System.out.println(map.getOrDefault(myMBTI, 0));
  }
}