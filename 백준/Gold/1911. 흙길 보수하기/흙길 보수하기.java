import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] water = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int idx = 0;
        int cnt = 0;

        for(int[] arr: water) {
            int start = arr[0];
            int end = arr[1];

            if (end <= idx) continue;
            else {
                if (idx > start) {
                    int tempCnt = 0;
                    tempCnt += (end - idx) / l;
                    if ((end - idx) % l != 0) {
                        tempCnt++;
                    }

                    idx = idx + tempCnt*l;
                    cnt += tempCnt;
                }
                else {
                    int tempCnt = 0;
                    tempCnt += (end - start) / l;
                    if ((end - start) % l != 0) {
                        tempCnt++;
                    }

                    idx = start + tempCnt*l;
                    cnt += tempCnt;
                }
            }
        }

        System.out.println(cnt);
    }
}
