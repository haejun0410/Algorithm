class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        while (n>0) {
            sb.append(n%3);
            n /= 3;
        }
        String arr = sb.reverse().toString();
        int tmp = 1;
        for (int i=0; i<arr.length(); i++) {
            answer += (tmp * Character.getNumericValue(arr.charAt(i)));
            tmp *= 3;
        }
        return answer;
    }
}
