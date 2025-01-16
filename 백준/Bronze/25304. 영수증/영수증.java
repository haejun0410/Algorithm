import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int n;
        x = sc.nextInt();
        n = sc.nextInt();
        int a,b;
        int total = 0;
        
        for (int i=0; i<n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            total += a*b;
        }

        if (total == x) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}