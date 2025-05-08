import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);

		for(int i=2; i*i <= n; i++) {
			if (isPrime[i]) {
				for(int j=i*i; j <=n; j+=i) {
					if (j%i == 0) {
						isPrime[j] = false;
					}
				}
			}
		}

		isPrime[0] = false;
		isPrime[1] = false;

		ArrayList<Integer> primes = new ArrayList<>();

		for(int i=0; i<n+1; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}
		
		int start = 0, end = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= n) {
                sum -= primes.get(start++);
            } 
			else if (end == primes.size()) {
                break;
            } 
			else {
                sum += primes.get(end++);
            }

            if (sum == n) count++;
        }

        System.out.println(count);

		
    }
}
