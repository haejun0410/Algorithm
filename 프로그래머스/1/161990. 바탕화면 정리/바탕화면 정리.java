class Solution {
    
    private static int lux = 100;
    private static int luy = 100;
    private static int rux = 0;
    private static int ruy = 0;
    public int[] solution(String[] wallpaper) {
        for(int i=0; i<wallpaper.length; i++) {
            for(int j=0; j<wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux = Math.min(lux, j);
                    luy = Math.min(luy, i);
                    rux = Math.max(rux, j);
                    ruy = Math.max(ruy, i);
                } 
            }
        }
        
        return new int[] {luy, lux, ruy+1, rux+1};
    }
}