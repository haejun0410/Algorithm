import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String number : phone_book) {
            map.put(number, 1);
        }
        
        for(String number : phone_book) {
            for(int i=0; i<number.length(); i++) {
                String prefix = number.substring(0, i);
                if (map.containsKey(prefix)) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}