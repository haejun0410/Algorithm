import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<word.length(); i++) {
            Character c = word.charAt(i);
            
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + 13) % 26 + 'A'));
            }
            else if ( c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + 13) % 26 + 'a'));
            }
            else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}