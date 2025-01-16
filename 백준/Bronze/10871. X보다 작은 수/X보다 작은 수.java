import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,x;
        n = sc.nextInt();
        x = sc.nextInt();
        int b = 0;
        for (int i=0; i<n; i++) {
            b = sc.nextInt();
            if (b < x) {
                System.out.print(b + " ");
            }
        }
    }
}