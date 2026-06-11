import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isWordStart = true;
        
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                isWordStart = true;
                sb.append(" ");
            }
            else {
                sb.append(isWordStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
                isWordStart = false;
            }
        }
        
        return sb.toString();
        
    }
}