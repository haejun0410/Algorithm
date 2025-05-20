import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int initialAttack = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][3];
        long end = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
            room[i][2] = Integer.parseInt(st.nextToken());

            if (room[i][0] == 1) {
                end += (long) room[i][1] * room[i][2];
            }
        }

        long start = 1;

        while (start <= end) {
            long mid = (start + end) / 2;
            long health = mid;
            long attack = initialAttack;
            boolean win = true;

            for (int i = 0; i < n; i++) {
                int type = room[i][0];

                if (type == 1) {
                    long dragonAttack = room[i][1];
                    long dragonHealth = room[i][2];

                    long turnsToKill = (dragonHealth + attack - 1) / attack;
                    long damage = dragonAttack * (turnsToKill - 1);
                    health -= damage;

                    if (health <= 0) {
                        win = false;
                        break;
                    }
                } else {
                    attack += room[i][1];
                    health = Math.min(mid, health + room[i][2]);
                }
            }

            if (win) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
