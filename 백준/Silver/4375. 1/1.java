import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        while (( line = br.readLine() ) != null ) {
            int number = Integer.parseInt(line);
            

            long tmp = 1;
            int cnt = 1;
            for(;;) {
                if (tmp % number == 0) {
                    System.out.println(cnt);
                    break;
                }
                else {
                    tmp = tmp*10 + 1;
                    tmp %= number;
                    cnt++;
                }
            }
        }
    }
}
