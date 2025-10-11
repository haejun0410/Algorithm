import java.util.*;

class Solution {
    List<Integer> candidateKeys = new ArrayList<>();

    public int solution(String[][] relation) {
        int colCount = relation[0].length;
        int rowCount = relation.length;

        for (int bit = 1; bit < (1 << colCount); bit++) {
            if (!isMinimal(bit)) continue;

            if (isUnique(bit, relation)) {
                candidateKeys.add(bit);
            }
        }

        return candidateKeys.size();
    }

    private boolean isMinimal(int bit) {
        for (int key : candidateKeys) {
            if ((key & bit) == key) return false;
        }
        return true;
    }

    private boolean isUnique(int bit, String[][] relation) {
        Set<String> set = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                if ((bit & (1 << i)) != 0) {
                    sb.append(row[i]).append(" ");
                }
            }
            set.add(sb.toString());
        }

        return set.size() == relation.length;
    }
}
