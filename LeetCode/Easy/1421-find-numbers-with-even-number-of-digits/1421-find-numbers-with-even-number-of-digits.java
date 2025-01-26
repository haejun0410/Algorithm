class Solution {
    public int findNumbers(int[] nums) {
        int answer = 0;
        
        for (int num : nums){
            int count = 0;
            
            if (num == 0){
                count = 1;
            }
            else{
                while (num > 0){
                    count ++;
                    num = num / 10;
                }
            }
            
            if (count %2 == 0){
                answer++;
            }
        }
        
        return answer;
    }
}