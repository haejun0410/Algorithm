import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String word = sc.next();

        int result = 0;

        for (int i=0; i<n; i++) {
            result += (word.charAt(i) - '0');
        }

        System.out.println(result);

    }
}