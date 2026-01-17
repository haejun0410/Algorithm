import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = "";
        int count = -1;

        for(int i=0; i<7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String seminar =  st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if (num > count) {
                name = seminar;
                count = num;
            }
        }
        
        System.out.println(name);
    }
}
