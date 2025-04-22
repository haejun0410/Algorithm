class Solution {
    public long solution(long n) {
        long temp = (long)Math.sqrt(n);
        
        if (temp * temp == n) {
            return (temp + 1) * (temp + 1);
        } 
        return -1;
    }
}