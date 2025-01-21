import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int [] result = new int[photo.length];
        
        HashMap<String, Integer> yearningMap = new HashMap<>();
        
        for (int i=0; i<name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }
        
        for (int i=0; i<photo.length; i++) {
            int yearningScore = 0;
            for (String person : photo[i]) {
                yearningScore += yearningMap.getOrDefault(person, 0);
            }
            
            result[i] = yearningScore;
        }
        
        return result;
        
    }
}