import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        int b = 0;
        int min = 1000000;
        int max = -1000000;

        for (int i=0; i<n; i++) {
            b = sc.nextInt();
            min = Math.min(min, b);
            max = Math.max(max, b);
        }

        System.out.println(min + " " + max);
    }
}