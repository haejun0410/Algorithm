class Solution {
    public int[] solution(int brown, int yellow) {
        int y = 1;
        int x = yellow / y;

        while (y <= x) {
            if (yellow % y == 0) {
                x = yellow / y;

                int count = 2 * y + 2 * x + 4;

                if (brown == count) {
                    return new int[]{x + 2, y + 2};
                }
            }

            y++;
        }

        return new int[]{y, x};
    }
}