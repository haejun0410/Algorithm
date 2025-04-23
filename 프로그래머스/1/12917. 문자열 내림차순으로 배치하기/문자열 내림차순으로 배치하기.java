import java.util.*;
 
class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder(new String(charArray));
        return sb.reverse().toString();
    }
}