import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        int answer = 0;
        for (int i=1; i<n+1; i++){
            answer += i;
        }

        System.out.println(answer);
    }
}