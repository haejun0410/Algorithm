import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case;
        int a,b;
        test_case = sc.nextInt();

        for(int i=0; i< test_case; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println("Case #" + (i+1) + ": " + a + " + " + b + " = " + (a+b));
        }
    }
}