import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int iter = 0;
        int count = 0;
        
        while(s.length() != 1) {
            iter++;
            int before = s.length();
            int numZero = 0;
            for (int i = 0; i < before; i++) {
                if (s.charAt(i) == '0') {
                    numZero++;
                }
            }
            
            int after = before - numZero;
            count += numZero;
            
            s = Integer.toBinaryString(after);
        }
        
        return new int[] {iter, count};
    }
}