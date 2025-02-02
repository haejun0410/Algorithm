import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        String word = br.readLine();

        for (int i=1; i<=word.length(); i++) {
            for (int j=0; j<=word.length() - i; j++) {
                set.add(word.substring(j, j+i));
            }
        }

        System.out.println(set.size());
    }
}