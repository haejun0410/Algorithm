import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];

        int heightSum = 0;

        for(int i=0; i<9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            heightSum += heights[i];
        }

        int targetSum = heightSum - 100;

        int exclude1 = -1;
        int exclude2 = -1;

        Arrays.sort(heights);

        outer:
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if (heights[i] + heights[j] == targetSum) {
                    exclude1 = i;
                    exclude2 = j;
                    break outer;
                }
            }
        }

        for(int i=0; i<9; i++) {
            if (i != exclude1 && i != exclude2) {
                System.out.println(heights[i]);
            }
        }
    }

}
