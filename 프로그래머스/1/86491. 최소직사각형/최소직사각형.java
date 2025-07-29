class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int r = 0;
        int l = 0;
        
        for(int[] size : sizes) {
            int maxValue = Math.max(size[0], size[1]);
            int minValue = Math.min(size[0], size[1]);
            
            r = Math.max(r, maxValue);
            l = Math.max(l, minValue);
        }
        return r*l;
    }
}