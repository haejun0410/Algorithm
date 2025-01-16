import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arr = new int[31];

        int b = 0;
        for (int i=0; i<28; i++) {
            b = sc.nextInt();
            arr[b] = 1;
        }

        for (int i=1; i<=30; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }
    }
}