class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int num = 0;
        int[] score = new int[3];
        int idx = -1;
        
        for(int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            
            if (ch == 'S') {
                idx++;
                score[idx] = num;
                num = 0;
            }
            else if (ch == 'D') {
                idx++;
                score[idx] = (int)Math.pow(num, 2);
                num = 0;
            }
            else if (ch == 'T') {
                idx++;
                score[idx] = (int)Math.pow(num, 3);
                num = 0;
            }
            else if (ch == '*') {
                score[idx] = 2*score[idx];
                if (idx-1 >= 0) {
                    score[idx-1] = 2*score[idx-1];
                }
            }
            else if (ch == '#') {
                score[idx] = -score[idx];
            }
        }
        for(int s : score) {
            answer += s;
        }
        return answer;
    }
}