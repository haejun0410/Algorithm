import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] ingredients = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            ingredients[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ingredients);

        int start = 0;
        int end = n-1;

        int count = 0;

        while (start < end) {
            int sum = ingredients[start] + ingredients[end];
            if (sum == m) {
                count++;
                start++;
                end--;
            }

            else if (sum < m) {
                start++;
            }
            else {
                end--;
            }
        }

        System.out.println(count);
    }
}
