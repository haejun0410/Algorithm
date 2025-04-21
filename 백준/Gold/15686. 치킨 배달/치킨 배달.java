import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static List<Node> chickens = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        int closeCount = chickens.size() - m;
        backtrack(0, 0, closeCount);

        System.out.println(answer);
    }

    public static void backtrack(int start, int count, int closeCount) {
        if (count == closeCount) {
            answer = Math.min(answer, calculateDistance());
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            Node chick = chickens.get(i);

            if (map[chick.y][chick.x] == 2) {
                map[chick.y][chick.x] = 0;
                backtrack(i + 1, count + 1, closeCount);
                map[chick.y][chick.x] = 2; 
            }
        }
    }

    public static int calculateDistance() {
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for (Node chick : chickens) {
                        if (map[chick.y][chick.x] == 2) {
                            int dist = Math.abs(chick.y - i) + Math.abs(chick.x - j);
                            min = Math.min(min, dist);
                        }
                    }
                    total += min;
                }
            }
        }
        return total;
    }

    public static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
