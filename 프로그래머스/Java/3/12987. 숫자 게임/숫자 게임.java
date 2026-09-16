import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int aPoint = 0;
        int bPoint = 0;
        
        while(aPoint < A.length && bPoint < B.length) {
            if (A[aPoint] < B[bPoint]) {
                answer++;
                aPoint++;
                bPoint++;
            }
            else {
                bPoint++;
            }
        }
        
        return answer;
    }
}