import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            int stack = 0;
            boolean flag = true;
            for(int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '(') {
                    stack++;
                }
                else {
                    if (stack == 0) {
                        flag = false;
                    }
                    else {
                        stack--;
                    }
                }
            }
            if (!flag || stack != 0) {
                sb.append("NO").append("\n");
            }
            else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
