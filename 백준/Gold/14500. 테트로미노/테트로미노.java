import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100001;

    static boolean[][][] IBlock = {
        {
            {true, true, true, true}
        },
        {
            {true},
            {true},
            {true}, 
            {true}
        }
    };

    static boolean[][][] OBlock = {
        {
            {true, true},
            {true, true}
        }
    };

    static boolean[][][] LBlock = {
        {
            {true, false},
            {true, false}, 
            {true, true}
        },
        {
            {false, true},
            {false, true}, 
            {true, true}
        },
        {
            {true, true, true},
            {true, false, false}
        },
        {
            {true, true, true},
            {false, false, true}
        },
        {
            {true, true},
            {false, true},
            {false, true}
        },
        {
            {true, true},
            {true, false},
            {true, false}
        },
        {
            {false, false, true},
            {true, true, true}
        },
        {
            {true, false, false},
            {true, true, true}
        }

    };

    static boolean[][][] ZBlock = {
        {
            {true, true, false}, 
            {false, true, true}
        },
        {
            {false, true}, 
            {true, true}, 
            {true, false}
        },
        {
            {false, true, true}, 
            {true, true, false}
        }, 
        {
            {true, false}, 
            {true, true}, 
            {false, true}
        } 
    };
    

    static boolean[][][] TBlock = {
        {
            {true, true, true}, 
            {false, true, false}
        },
        {
            {true, false}, 
            {true, true}, 
            {true, false}
        },
        {
            {false, true, false}, 
            {true, true, true}
        },
        {
            {false, true}, 
            {true, true}, 
            {false, true}
        },
        {
            {true, true, true}, 
            {true, false, false}
        }, 
        {
            {false, true}, 
            {true, true}, 
            {false, true}
        }, 
        {
            {true, false}, 
            {true, true}, 
            {true, false}
        }, 
        {
            {false, true, false}, 
            {true, true, true}
        } 
    };
    
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = -1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                for(boolean[][] block : IBlock) {
                    if (block[0].length + j -1< m && block.length + i -1< n) {
                        max = Math.max(max, calc(block, i, j));
                    }
                }

                for(boolean[][] block : LBlock) {
                    if (block[0].length + j -1 < m  && block.length + i -1< n) {
                        max = Math.max(max, calc(block, i, j));
                    }
                }

                for(boolean[][] block : ZBlock) {
                    if (block[0].length + j -1 < m  && block.length + i -1 < n) {
                        max = Math.max(max, calc(block, i, j));
                    }
                }

                for(boolean[][] block : TBlock) {
                    if (block[0].length + j -1 < m && block.length + i -1 < n) {
                        max = Math.max(max, calc(block, i, j));
                    }
                }
                for(boolean[][] block : OBlock) {
                    if (block[0].length + j -1 < m  && block.length + i -1 < n) {
                        max = Math.max(max, calc(block, i, j));
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int calc(boolean[][] block, int y, int x) {
        int value = 0;

        for (int i=0; i<block.length; i++) {
            for (int j=0; j<block[0].length; j++) {
                if (block[i][j]) {
                    value += map[y+i][x+j];
                }
            }
        }
        return value;
    }
}
