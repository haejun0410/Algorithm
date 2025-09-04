import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sentence.length(); i++){
            Character c = sentence.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append((char)((c - 'a' + 13) % 26 + 'a'));
            }
            else if (c >= 'A' && c <= 'Z') {
                sb.append((char)((c - 'A' + 13) % 26 + 'A'));
            }
            else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }
}
