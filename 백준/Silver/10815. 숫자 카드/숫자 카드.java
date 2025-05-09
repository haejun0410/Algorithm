import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int[] nArray;
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        nArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray);

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());

            bw.write(BinarySearch(num) + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int BinarySearch(int num) {
        int left = 0;
        int right = n-1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = nArray[middle];

            if (num > middleValue) {
                left = middle + 1;
            }
            else if (num < middleValue) {
                right = middle -1;
            }
            else {
                return 1;
            }
        }
        return 0;
    }
}