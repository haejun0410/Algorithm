import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        
        while(st.hasMoreTokens()) {
            int val = Integer.parseInt(st.nextToken());
            minValue = Math.min(minValue, val);
            maxValue = Math.max(maxValue, val);
        }
        
        return minValue + " " + maxValue;
    }
}