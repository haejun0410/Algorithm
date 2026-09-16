import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> alphaInfo = new HashMap<>();
        int[] result = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (alphaInfo.containsKey(ch)) {
                result[i] = (i - alphaInfo.get(ch));
                alphaInfo.replace(ch, i);
            }
            else {
                alphaInfo.put(ch, i);
                result[i] = -1;
            }
        }
        return result;
    }
}