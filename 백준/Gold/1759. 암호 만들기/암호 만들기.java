import java.util.*;
import java.io.*;

public class Main {
	
	static int L;
	static int C;
	static char[] alphabets;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String line = br.readLine();
		alphabets = new char[C];
		
		for(int i = 0; i < C; i++) {
			alphabets[i] = line.charAt(i*2);
		}
		Arrays.sort(alphabets);
		
		recursion(0, 0, 0, 0, "");
	
	}
	
	public static void recursion(int depth, int index, int vowels, int consonants, String password) {
		if (depth == L) {
			if (vowels >= 1 && consonants >= 2) {
				System.out.println(password);
			}
		}
		
		for (int i = index; i < C; i++) {
            char current = alphabets[i];
            if (isVowel(current)) {
            	recursion(depth + 1, i + 1, vowels + 1, consonants, password + current);
            } else {
            	recursion(depth + 1, i + 1, vowels, consonants + 1, password + current);
            }
        }
		
	}
	
	public static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

}
