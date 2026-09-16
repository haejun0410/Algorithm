import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();

        for (String log : record) {
            String[] info = log.split(" ");
            String command = info[0];
            String uid = info[1];

            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = info[2];
                user.put(uid, nickname);
            }
        }

        List<String> messages = new ArrayList<>();
        for (String log : record) {
            String[] info = log.split(" ");
            String command = info[0];
            String uid = info[1];

            if (command.equals("Enter")) {
                messages.add(user.get(uid) + "님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                messages.add(user.get(uid) + "님이 나갔습니다.");
            }
        }

        return messages.toArray(new String[0]);
    }
}
