import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String m;
        n = sc.nextInt();
        m = sc.next();

        System.out.println(n * (m.charAt(2) - '0'));
        System.out.println(n * (m.charAt(1) - '0'));
        System.out.println(n * (m.charAt(0) - '0'));
        System.out.println(n * Integer.parseInt(m));

        
    }
}