import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h,m;

        h = sc.nextInt();
        m = sc.nextInt();

        if (m < 45) {
            h -= 1;
            if (h == -1) {
                h = 23;
            }
            m = m + 60;
        }
        m -= 45;

        System.out.println(h + " " + m);
    }
}