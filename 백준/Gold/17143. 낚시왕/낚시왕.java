import java.io.*;
import java.util.*;

public class Main {

    static int[][][] board;
    static int r,c;

    // 0 -> 위, 1-> 아래, 2-> 오른쪽, 3-> 왼쪽
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[] changeDirection = {1, -1, 1, -1};

    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[r][c][3];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            // 0 -> 속력 , 1 -> 이동방향, 2 -> 크기
            board[y][x][0] = Integer.parseInt(st.nextToken());
            board[y][x][1] = Integer.parseInt(st.nextToken()) - 1;
            board[y][x][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<c; i++) {
            catchShark(i);
            moveShark();
        }

        System.out.println(total);

    }

    public static void moveShark() {
        int[][][] newBoard = new int[r][c][3];
    
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j][2] != 0) { 
                    int y = i;
                    int x = j;
                    int speed = board[i][j][0];
                    int dir = board[i][j][1];
                    int size = board[i][j][2];
    
                    if (dir == 0 || dir == 1) {
                        speed %= (r - 1) * 2;
                    } else {
                        speed %= (c - 1) * 2;
                    }
    
                    for (int s = 0; s < speed; s++) {
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];
    
                        if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                            if (dir == 0) dir = 1;
                            else if (dir == 1) dir = 0;
                            else if (dir == 2) dir = 3;
                            else if (dir == 3) dir = 2;
    
                            ny = y + dy[dir];
                            nx = x + dx[dir];
                        }
    
                        y = ny;
                        x = nx;
                    }
    

                    if (newBoard[y][x][2] < size) {
                        newBoard[y][x][0] = board[i][j][0];
                        newBoard[y][x][1] = dir;
                        newBoard[y][x][2] = size;
                    }
                }
            }
        }
    
        board = newBoard;
    }
    
    

    public static void catchShark(int pos) {
        for(int i=0; i<r; i++) {
            if (board[i][pos][2] != 0) {
                total += board[i][pos][2];

                board[i][pos][0] = 0;
                board[i][pos][1] = 0;
                board[i][pos][2] = 0;
                return;
            }
        }
    }


}
