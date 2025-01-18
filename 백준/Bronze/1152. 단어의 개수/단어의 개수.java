import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = "";
        int count = 0;
        while (sc.hasNext()) {
            word = sc.next();
            count++;
        }

        System.out.println(count);
    }
}