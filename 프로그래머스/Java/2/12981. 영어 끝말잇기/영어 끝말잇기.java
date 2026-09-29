import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int turn = 1;
        int num = 2;
        String word = words[0];
        
        HashSet<String> set = new HashSet<>();
        set.add(word);
        
        for (int i = 1; i < words.length; i++) {
            String next = words[i];
            
            if (word.charAt(word.length()-1) != next.charAt(0) || set.contains(next)) {
                return new int[] {num, turn};
            }
            
            word = next;
            set.add(next);
            num += 1;
            
            if (num == n+1) {
                turn += 1;
                num = 1;
            }
        }
        
        return new int[] {0, 0};
        
        
    }
}