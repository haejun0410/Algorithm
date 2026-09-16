import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for (char ch : a.toCharArray()){
            if (Character.isUpperCase(ch)){
                System.out.print(Character.toLowerCase(ch));
            }
            else {
                System.out.print(Character.toUpperCase(ch));
            }
        }
    }
}