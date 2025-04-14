import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(;;) {
        String number = br.readLine();
        
        if (Integer.parseInt(number) == 0) {
          break;
        }
        
        int start = 0;
        int end = number.length()-1;
        
        boolean isPalindrome = true;
        
        while (start < end) {
          if (number.charAt(start) != number.charAt(end)) {
            isPalindrome = false;
            break;
          }
          else {
            start++;
            end--;
          }
        }
        
        if (isPalindrome) {
          System.out.println("yes");
        }
        else {
          System.out.println("no");
        }
      }
  }
}