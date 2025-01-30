import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String word = br.readLine();

            int count = 0;
            
            for (int j=0; j<=word.length()-3; j++) {
                if (word.substring(j, j+3).equals("WOW")) {
                    count++;
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
        bw.close();
    }
}