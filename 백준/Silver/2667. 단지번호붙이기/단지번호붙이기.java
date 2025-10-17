import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int count = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && board[i][j] == 1) {
                    count++;
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                    int size = 0;
                    while(!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        size++;
                        for(int k=0; k<4; k++) {
                            int ny = curr[0] + dy[k];
                            int nx = curr[1] + dx[k];

                            if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
                                if (!visited[ny][nx] && board[ny][nx] == 1) {
                                    queue.offer(new int[] {ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                    counts.add(size);
                }
            }
        }

        Collections.sort(counts);

        System.out.println(count);
        for(int s : counts) {
            System.out.println(s);
        }
    }
}
