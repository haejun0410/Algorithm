import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length() -1; i++) {
            String sub = str1.substring(i, i+2);
            if (Character.isAlphabetic(sub.charAt(0)) && Character.isAlphabetic(sub.charAt(1))) {
                map1.put(sub, map1.getOrDefault(sub, 0) + 1);
            }
        }
        
        for(int i=0; i<str2.length() -1; i++) {
            String sub = str2.substring(i, i+2);
            if (Character.isAlphabetic(sub.charAt(0)) && Character.isAlphabetic(sub.charAt(1))) {
                map2.put(sub, map2.getOrDefault(sub, 0) + 1);
            }
        }
        
        HashSet<String> keySet = new HashSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        
        double intersectSize = 0;
        double unionSize = 0;
        
        for(String key : keySet) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            intersectSize += Math.min(count1, count2);
            unionSize += Math.max(count1, count2);
        }
        
        if (unionSize == 0) {
            return 65536;
        }
        else {
            double jaccard = intersectSize / unionSize;
            return (int) (jaccard * 65536);
        }
        
        
    }
}