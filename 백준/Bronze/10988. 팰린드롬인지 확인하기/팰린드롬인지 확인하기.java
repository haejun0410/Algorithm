import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        int a = 0;
        int b = word.length() -1;


        boolean flag = false;
        
        while (a < b) {
            if (word.charAt(a) != word.charAt(b)) {
                flag = true;
                break;
            }    
            a++;
            b--;
        }

        System.out.println(flag ? 0 : 1);
    }
}