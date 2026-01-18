import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double i = Double.parseDouble(st.nextToken());
        double j = Double.parseDouble(st.nextToken());
        double k = Double.parseDouble(st.nextToken());

        double t = Math.min(a / i, Math.min(b / j, c / k));

        System.out.printf("%.6f %.6f %.6f\n",
                a - i * t,
                b - j * t,
                c - k * t
        );
    }
}
