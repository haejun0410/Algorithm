import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static boolean[] visited;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][4];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
            nums[i][3] = Integer.parseInt(st.nextToken());
        }
        
        int[] arr1 = new int[n*n];
        int[] arr2 = new int[n*n];

        int idx = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr1[idx] = nums[i][0] + nums[j][1];
                arr2[idx] = nums[i][2] + nums[j][3];
                idx++;
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long answer = 0;

        int left = 0;
        int right = n*n-1;

        while(left < n*n && right >= 0) {
            if (arr1[left] + arr2[right] < 0) {
                left++;
            }
            else if (arr1[left] + arr2[right] > 0) {
                right--;
            }
            else {
                long leftCount = 1;
                long rightCount = 1;

                while (left + 1 < n*n && (arr1[left] == arr1[left+1])) {
                    leftCount++;
                    left++;
                }
                while (right > 0 && (arr2[right] == arr2[right-1])) {
                    rightCount++;
                    right--;
                }

                answer += leftCount * rightCount;
                left++;
            }
        }
        System.out.println(answer);
        
    }
}
