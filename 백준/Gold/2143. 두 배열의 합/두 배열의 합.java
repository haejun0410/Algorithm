import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> aSum = getAllSums(a);
        ArrayList<Integer> bSum = getAllSums(b);

        Collections.sort(aSum);
        Collections.sort(bSum, Collections.reverseOrder());

        long count = 0;

        int p1 = 0;
        int p2 = 0;

        while (p1 < aSum.size() && p2 < bSum.size()) {
            int sumA = aSum.get(p1);
            int sumB = bSum.get(p2);
            int total = sumA + sumB;

            if (total == t) {
                long countA = 0;
                long countB = 0;
                while (p1 < aSum.size() && aSum.get(p1) == sumA) {
                    countA++;
                    p1++;
                }
                while (p2 < bSum.size() && bSum.get(p2) == sumB) {
                    countB++;
                    p2++;
                }
                count += countA * countB;
            } else if (total < t) {
                p1++;
            } else {
                p2++;
            }
        }

        System.out.println(count);

    }

    static ArrayList<Integer> getAllSums(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                result.add(sum);
            }
        }
        return result;
    }
}