class Solution {
    
    private static int boardLength;
    private static int count;
    private static int[] dy;
    private static int[] dx;
    private static String currentColor;
    private static String[][] board;
    public int solution(String[][] board, int h, int w) {
        this.board = board;
        boardLength = board[0].length;
        currentColor = board[h][w];
        dy = new int[] {0,0,1,-1};
        dx = new int[] {1,-1,0,0};
        count = 0;
        check(h,w);
        return count;
    }
    
    private boolean inRange(int y, int x) {
        return 0 <= y && y < boardLength && 0 <= x && x < boardLength;
    }
    
    private void check(int h, int w) {
        for (int i=0; i<4; i++) {
            int nh = h + dy[i];
            int nw = w + dx[i];
            
            if (inRange(nh, nw)) {
                if (board[nh][nw].equals(currentColor)) {
                    count++;
                }
            }
        }
    }
}