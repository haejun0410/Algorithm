class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<food.length; i++) {
            for (int j=0; j<food[i] / 2; j++) {
                sb.append(i);
            }
        }
        
        StringBuilder rival = new StringBuilder(sb.reverse());
        sb.reverse();
        sb.append(0);
        
        return sb.toString() + rival.toString();
    }
}