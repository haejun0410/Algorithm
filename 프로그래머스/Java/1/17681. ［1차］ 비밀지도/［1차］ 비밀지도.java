class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            int map = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<1<<n; j*=2) {
                if ((map & j) >= 1) {
                    sb.append("#");
                }
                else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.reverse().toString();
        }
        
        return answer;
    }
}