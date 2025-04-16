import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for (int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int diff = sum-100;
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        
        outer:
        for (int i=0; i<8; i++) {
            for (int j=i+1; j<9; j++) {
                if (arr[i] + arr[j] == diff) {
                    for(int k=0; k<9; k++) {
                        if (k!=i && k!= j) {
                            sb.append(arr[k]).append("\n");
                        }
                    }
                    break outer;
                }
            }
        }

        System.out.println(sb);
    }
}