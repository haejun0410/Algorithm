import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] space = new int[10];
        Arrays.fill(space, 3);
        space[1] = 2;
        space[0] = 4;

        for(;;) {
            String num = br.readLine();

            if (num.equals("0")) break;

            int length = 0;
            for(int i=0; i<num.length(); i++) {
                length += space[num.charAt(i) - '0'];
            }

            length += (num.length() + 1);

            System.out.println(length);
        }
    }

}
