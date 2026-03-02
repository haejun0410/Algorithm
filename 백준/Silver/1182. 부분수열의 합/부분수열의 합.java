import java.io.*;
import java.util.*;

public class Main {

    static int n,s;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // n개의 정수
        n = Integer.parseInt(st.nextToken());
        // 목표 합
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtracking(0, 0);
        System.out.println(s == 0 ? count-1 : count);

    }

    public static void backtracking(int index, int sum) {
        if (index == n) {
            if (sum == s) count++;
            return;
        }

        backtracking(index +1, sum + arr[index]);
        backtracking(index +1, sum);
    }
}