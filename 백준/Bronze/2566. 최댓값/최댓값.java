import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int y = 0;
        int x = 0;

        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > max) {
                    max = num;
                    y = i + 1;
                    x = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(y + " " + x);
        
    }
}