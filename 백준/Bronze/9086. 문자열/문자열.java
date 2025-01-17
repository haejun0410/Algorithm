import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String word = sc.next();
            System.out.print(word.charAt(0));
            System.out.println(word.charAt(word.length() - 1));
        }

    }
}