import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int selectNum = nums.length/2;
        answer = Math.min(selectNum, map.keySet().size());
        return answer;
    }
}