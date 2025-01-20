import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sizeList = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<6; i++) {
            sizeList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int t_sum = 0;
        for (int i=0; i<6; i++) {
            t_sum += (sizeList[i] / t + 1);
            if (sizeList[i] % t == 0) {
                t_sum--;
            }
        }
        sb.append(t_sum + "\n");
        int p_g = n / p;
        int p_i = n % p;
        sb.append(p_g + " " + p_i);

        System.out.println(sb);

        

        
    }
}