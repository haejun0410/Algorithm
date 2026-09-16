class Solution {
    public int solution(String t, String p) {
        int result = 0;
        int subStringLength = p.length();
        
        for (int i=0; i<=t.length() - subStringLength; i++) {
            long subString = Long.parseLong(t.substring(i, i+subStringLength));
            
            if (subString <= Long.parseLong(p)) {
                result++;
            }
        }
        
        return result;
    }
}
