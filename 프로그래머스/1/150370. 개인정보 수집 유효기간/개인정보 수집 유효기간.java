import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> termInfo = new HashMap<>();
        String[] todayInfo = today.split("\\.");
        ArrayList<Integer> expiredIndices = new ArrayList<>();
        
        for (String term : terms) {
            String[] t = term.split(" ");
            termInfo.put(t[0], Integer.parseInt(t[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacle = privacies[i].split(" ");
            String[] joinDate = privacle[0].split("\\.");
            
            int year = Integer.parseInt(joinDate[0]);
            int month = Integer.parseInt(joinDate[1]);
            int day = Integer.parseInt(joinDate[2]);
            
            month += termInfo.get(privacle[1]);
            
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
            
            if (year < Integer.parseInt(todayInfo[0]) || 
                (year == Integer.parseInt(todayInfo[0]) && month < Integer.parseInt(todayInfo[1])) ||
                (year == Integer.parseInt(todayInfo[0]) && month == Integer.parseInt(todayInfo[1]) && day <= Integer.parseInt(todayInfo[2]))) {
                expiredIndices.add(i + 1);
            }
        }
        
        return expiredIndices.stream().mapToInt(Integer::intValue).toArray();
    }
}