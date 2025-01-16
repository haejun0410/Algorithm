import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int a,b,c;

        int [] arr = new int[n];
        
        for (int i=0; i<m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            for (int j=a; j<=b; j++) {
                arr[j-1] = c;
            }
        }

        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}