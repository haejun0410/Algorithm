import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        while (sound.length() > 0) {
            if (sound.startsWith("pi")) {
                sound = sound.substring(2); 
            } 
            else if (sound.startsWith("ka")) {
                sound = sound.substring(2); 
            } 
            else if (sound.startsWith("chu")) {
                sound = sound.substring(3);
            } 
            else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
