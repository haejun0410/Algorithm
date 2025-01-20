import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(;;) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0 && z == 0) {
                break;
            } 

            if (x*x == (y*y + z*z)) {
                System.out.println("right");
            }
            else if (y*y == (x*x + z*z)) {
                System.out.println("right");
            }
            else if (z*z == (x*x + y*y)) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }
        }
        
    
    }
}