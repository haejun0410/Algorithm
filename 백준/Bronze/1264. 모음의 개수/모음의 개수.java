import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(;;) {
            String line = br.readLine();

            if (line.equals("#")) break;

            int count = 0;

            for(int i=0; i<line.length(); i++) {
                char ch = Character.toLowerCase(line.charAt(i));

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

}
