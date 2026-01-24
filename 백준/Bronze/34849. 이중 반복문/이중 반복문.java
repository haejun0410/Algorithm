import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 10000) {
            System.out.println("Accepted");
        }
        else {
            System.out.println("Time limit exceeded");
        }
        
    }
}
