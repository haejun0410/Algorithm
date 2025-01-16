import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int count = 0;
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int b = sc.nextInt();

        for (int j=0; j<n; j++) {
            if (arr[j] == b) {
                count++;
            }
        }

        System.out.println(count);
    }
}