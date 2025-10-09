class Solution {
    
    public int solution(int m, int n, String[] board) {
        
        int answer = 0;
        
        char[][] charBoard = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }
        
        while(true) {
            int removeCount = 0;
            boolean[][] remove = new boolean[m][n];
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    char block = charBoard[i][j];
                    if (block != '0' && block == charBoard[i][j + 1] && block == charBoard[i + 1][j] && block == charBoard[i + 1][j + 1]) {
                        remove[i][j] = true;
                        remove[i+1][j] = true;
                        remove[i][j+1] = true;
                        remove[i+1][j+1] = true;
                    }
                }
            }
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if (remove[i][j]) {
                        charBoard[i][j] = '0';
                        removeCount++;
                    }
                }
            }
            
            if (removeCount == 0) break;
            
            answer += removeCount;
            
            for (int j = 0; j < n; j++) {
                for (int i = m - 1; i >= 0; i--) {
                    if (charBoard[i][j] == '0') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (charBoard[k][j] != '0') {
                                charBoard[i][j] = charBoard[k][j];
                                charBoard[k][j] = '0';
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
