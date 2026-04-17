import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int indexA = 0;
        int indexB = 0;
        
        while (indexB < B.length) {
            if (B[indexB] > A[indexA]) {
                answer++;
                indexA++;
            }
            indexB++;
        }
        
        return answer;
    }
}