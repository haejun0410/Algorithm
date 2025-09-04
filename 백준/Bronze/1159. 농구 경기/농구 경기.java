import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        int num = Integer.parseInt(br.readLine());

        for (int i=0; i<num; i++) {
            arr[br.readLine().charAt(0) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= 5) {
                sb.append((char)(i + 'a'));
            }
        }

        if (sb.toString().isEmpty()) {
            System.out.println("PREDAJA");
        }
        else {
            System.out.println(sb);
        }
    }
}