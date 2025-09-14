import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            int cnt = 0;
            boolean isVPS = true;
            for(int j=0; j<line.length(); j++) {
                char ch = line.charAt(j);
                if (ch == '(') {
                    cnt++;
                }
                else {
                    if (cnt == 0) {
                        isVPS = false;
                        break;
                    }
                    else {
                        cnt--;
                    }
                }
            }

            if (!isVPS || cnt > 0) {
                sb.append("NO").append("\n");
            }
            else{
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}
