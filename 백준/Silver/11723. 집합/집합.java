import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int set = 0;
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                int num = Integer.parseInt(st.nextToken());

                set |= (1 << num);
            }

            else if (command.equals("remove")) {
                int num = Integer.parseInt(st.nextToken());

                set &= ~(1 << num);
            }

            else if (command.equals("check")) {
                int num = Integer.parseInt(st.nextToken());

                if ((set & (1 << num)) != 0) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }

            else if (command.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());

                set ^= (1 << num);
            }

            else if (command.equals("all")) {
                set = (1 << 21) - 1;
            }

            else if (command.equals("empty")) {
                set = 0;
            }
        }
        System.out.println(sb);
    }
    
}
