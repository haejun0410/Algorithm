import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		List<BigInteger> arr = new ArrayList<>();

		for (int i=0; i<n; i++) {
			String str = br.readLine();

			String number = "";
			for (int j=0; j<str.length(); j++) {
				Character chr = str.charAt(j);

				if (Character.isDigit(chr)) {
					number += chr;
				}

				else {
					if (number.length() > 0) {
						arr.add(new BigInteger(number));
						number = "";
					}
				}
			}

			if (number.length() > 0) {
				arr.add(new BigInteger(number));
			}
		}

		Collections.sort(arr);

		for (int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
}