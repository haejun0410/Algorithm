import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int score1 = 0, score2 = 0;

        int leadTeam = 0;
        int lastTime = 0; 

        int[] total = new int[3]; 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String[] timeStr = st.nextToken().split(":");
            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            if (team == 1) score1++;
            else score2++;

            int currentLeader = score1 > score2 ? 1 : score2 > score1 ? 2 : 0;

            if (leadTeam != currentLeader) {
                if (leadTeam != 0) {
                    total[leadTeam] += (time - lastTime);
                }
                lastTime = time;
                leadTeam = currentLeader;
            }
        }

        if (leadTeam != 0) {
            total[leadTeam] += (48 * 60 - lastTime);
        }

        for (int i = 1; i <= 2; i++) {
            int min = total[i] % 60;
            int hour = total[i] / 60;
            System.out.printf("%02d:%02d\n", hour, min);
        }
    }
}
