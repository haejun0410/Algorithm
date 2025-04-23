public class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.split(" ", -1);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (j % 2 == 0) {
                    answer.append(Character.toUpperCase(c));
                } else {
                    answer.append(Character.toLowerCase(c));
                }
            }

            if (i < words.length - 1) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}
