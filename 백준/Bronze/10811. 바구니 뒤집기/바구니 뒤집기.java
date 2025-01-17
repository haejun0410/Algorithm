import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i=0; i<n+1; i++) {
            arr[i] = i;
        }

        int a,b;
        int temp = 0;
        for (int j=0; j<m; j++) {
            a = sc.nextInt();
            b = sc.nextInt();

            while (a < b) {
                temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
                a++;
                b--;
            }
        }

        for (int i=1; i<n+1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}