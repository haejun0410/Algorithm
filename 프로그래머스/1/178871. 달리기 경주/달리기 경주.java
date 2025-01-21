import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> playerInfo = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            playerInfo.put(players[i], i);
        }
        
        for(String calling : callings) {
            int index = playerInfo.get(calling);
            String prevPlayer = players[index-1];
            
            playerInfo.replace(prevPlayer, index);
            playerInfo.replace(calling, index-1);
            
            players[index-1] = calling;
            players[index] = prevPlayer;
        }
        
        return players;
    }
}