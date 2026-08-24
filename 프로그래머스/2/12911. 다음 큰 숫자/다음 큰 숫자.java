class Solution {
    public int solution(int n) {
        int count = countBit(n);
        
        int next = n+1;
        
        while(countBit(next) != count) {
            next++;
        }
        
        return next;
    }
    
    private int countBit(int n) {
        int count = 0;
        
        while(n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        
        return count;
    }
}