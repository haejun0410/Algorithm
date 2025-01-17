import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();
        double[] arr = new double[n];


        double max = 0;
        
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextDouble();
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        double answer = 0;
        for (int i=0; i<n; i++) {
            arr[i] = (arr[i] / max) * 100;
            answer += arr[i];
        }
        System.out.println(answer / n);

    }
}