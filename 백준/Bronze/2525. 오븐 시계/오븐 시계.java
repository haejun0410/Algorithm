import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        b += c;

        a += (b / 60);
        b = b % 60;
        a = a % 24;

        System.out.println(a + " " + b);
    }
}