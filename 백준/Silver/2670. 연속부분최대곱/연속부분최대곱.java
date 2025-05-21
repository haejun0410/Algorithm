import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double current = arr[0];
        double ret = -1.0;

        for(int i=1; i<n; i++) {
            current = Math.max(arr[i], current * arr[i]);
            ret = Math.max(current, ret);
        }

        System.out.printf("%.3f", ret);
    }
}
