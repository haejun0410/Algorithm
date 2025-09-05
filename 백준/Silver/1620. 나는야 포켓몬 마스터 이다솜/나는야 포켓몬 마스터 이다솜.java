import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        HashMap<String, String> nameToNum = new HashMap<>();
        HashMap<String, String> numToName = new HashMap<>();

        for(int i=1; i<n+1; i++) {
            String name = br.readLine();
            nameToNum.put(name, String.valueOf(i));
            numToName.put(String.valueOf(i), name);
        }


        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            String target = br.readLine();
            if (Character.isAlphabetic(target.charAt(0))) {
                sb.append(nameToNum.get(target)).append("\n");
            }
            else {
                sb.append(numToName.get(target)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}