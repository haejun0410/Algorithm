import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[6];
        for (int i=0; i<6; i++) {
            arr[i] = sc.nextInt();
        }

        int[] chess = {1, 1, 2, 2, 2, 8};

        int diff = 0;
        for (int i=0; i<6; i++) {
            diff = chess[i] - arr[i];
            System.out.print(diff + " ");
        }
    }
}