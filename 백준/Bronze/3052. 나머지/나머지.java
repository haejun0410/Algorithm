import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rest = new int[42];

        int a;
        int count = 0;
        for (int i=0; i<10; i++) {
            a = sc.nextInt();
            rest[a % 42]++;
        }

        for(int num: rest) {
            if (num != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}