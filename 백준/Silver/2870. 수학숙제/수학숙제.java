import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<BigInteger> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            StringBuilder builder = new StringBuilder();
            for(int j=0; j<line.length(); j++) {
                if (Character.isDigit(line.charAt(j))) {
                    builder.append(line.charAt(j));
                }
                else {
                    if (!builder.toString().isEmpty()) {
                        list.add(new BigInteger(builder.toString()));
                        builder = new StringBuilder();
                    }
                }
            }

            if (!builder.toString().isEmpty()) {
                list.add(new BigInteger(builder.toString()));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(BigInteger num : list) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

}
