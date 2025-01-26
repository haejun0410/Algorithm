class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int count = 0;
        for (int num : nums){
            if (num == 0){
                count = 0;
            }
            else{
                count++;
                max_count = Math.max(max_count, count);
            }
        }
        
        return max_count;
    }
}