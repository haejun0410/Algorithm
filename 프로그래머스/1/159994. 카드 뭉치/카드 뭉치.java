class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;
        
        for (int i=0; i<goal.length; i++) {
            String currentWord = goal[i];
            
            if (card1Index < cards1.length && currentWord.equals(cards1[card1Index])) {
                card1Index++;
            }
            else if (card2Index < cards2.length && currentWord.equals(cards2[card2Index])) {
                card2Index++;
            }
            else {
                return "No";
            }
        }
        
        return "Yes";
    }
}