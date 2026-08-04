import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] temp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(temp, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if (temp[0].equals("0")) {
            return "0";
        }
        
        for (String s : temp) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}