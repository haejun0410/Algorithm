import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int xA = sc.nextInt();
        int yA = sc.nextInt();
        int xB = sc.nextInt();
        int yB = sc.nextInt();
        int xC = sc.nextInt();
        int yC = sc.nextInt();
        
        double difference = findPerimeterDifference(xA, yA, xB, yB, xC, yC);
        
        System.out.println(difference);
    }
    
    private static double findPerimeterDifference(int xA, int yA, int xB, int yB, int xC, int yC) {
        if (isCollinear(xA, yA, xB, yB, xC, yC)) {
            return -1;
        }
        
        double AB = distance(xA, yA, xB, yB);
        double AC = distance(xA, yA, xC, yC);
        double BC = distance(xB, yB, xC, yC);
        
        double maxPerimeter = Math.max( 2 * (AB + AC), Math.max(2 * (AB + BC), 2 * (AC + BC)) );
        double minPerimeter = Math.min( 2 * (AB + AC), Math.min(2 * (AB + BC), 2 * (AC + BC)) );
        
        return maxPerimeter - minPerimeter;
    }
    
    private static boolean isCollinear(int xA, int yA, int xB, int yB, int xC, int yC) {

        return (xB - xA) * (yC - yA) == (xC - xA) * (yB - yA);
    }
    
    private static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}