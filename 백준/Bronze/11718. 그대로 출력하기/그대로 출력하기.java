import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = "";
        while (sc.hasNext()) {
            word = sc.nextLine();
            System.out.println(word);
        }
    }
}