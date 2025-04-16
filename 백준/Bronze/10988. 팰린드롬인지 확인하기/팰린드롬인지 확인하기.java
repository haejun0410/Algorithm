import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder(str);
        String revStr = sb.reverse().toString();

        if (str.equals(revStr)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}