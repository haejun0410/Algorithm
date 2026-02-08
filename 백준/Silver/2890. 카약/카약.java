import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int cnt = 1;

        char[][] line = new char[R][C];
        for (int i = 0; i < R; i++) {
            String l = br.readLine();
            for (int j = 0; j < C; j++) {
                line[i][j] = l.charAt(j);
            }
        }
        int[] ans = new int[10];
        for(int i=0; i<10; i++){
            ans[i]=0;
        }

        boolean found = false;

        for (int i = C - 2; i > 0; i--) {
            for (int j = 0; j < R; j++) {
                if (!(line[j][i] == '.') && ans[Integer.parseInt(String.valueOf(line[j][i]))]==0) {
                    ans[Integer.parseInt(String.valueOf(line[j][i]))] = cnt;
                    found=true;
                }
            }
            if(found) {
                cnt++;
                found=false;
            }
        }
        for (int j = 1; j < 10; j++) {
            System.out.println(ans[j]);
        }
    }
}