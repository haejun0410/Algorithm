import java.util.*;
import java.io.*;

public class Main{

    static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        while((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int length = (int) Math.pow(3, n);

            char[] arr = new char[length];
            Arrays.fill(arr, '-');
            cantor(arr, 0, length);

            System.out.println(new String(arr));
        }
    }

    public static void cantor(char[] arr, int start, int size) {
        if (size == 1) return;

        int third = size / 3;

        for(int i = start + third; i < start + 2 * third; i++) {
            arr[i] = ' ';
        }

        cantor(arr, start, third);
        cantor(arr, start + 2 * third, third);
    }
}