import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = -1;
        int index = -1;
        int number = 0;
        for(int i=0; i<9; i++) {
            number = sc.nextInt();
            if (number > max) {
                max = number;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index+1);
    }
}