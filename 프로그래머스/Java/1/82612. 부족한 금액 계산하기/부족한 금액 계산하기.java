class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long finalPrice = 0;
        for (int i=1; i<= count; i++) {
            finalPrice += i*price;
        }
        answer = finalPrice - (long)money;
        
        if (answer < 0) {
            return 0;
        }
        return answer;
    }
}