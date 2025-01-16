import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        for (int i=1; i<n+1; i++) {
            for (int j=0; j<n-i; j++) {
                System.out.print(" ");
            }
            for (int k=0; k<i; k ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}