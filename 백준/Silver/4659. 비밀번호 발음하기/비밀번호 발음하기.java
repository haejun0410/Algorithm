import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

		StringBuilder sb = new StringBuilder();

		for(;;) {
			String str = br.readLine();
			if (str.equals("end")) break;

			int vowelsCount = 0;
			int consonantsCount = 0;
			boolean hasVowel = false;
			boolean allowable = true;
			
			Character lastCharacter = ' ';

			for (int i=0; i<str.length(); i++) {
				Character chr = str.charAt(i);

				if (vowels.contains(chr)) {
					hasVowel = true;
					vowelsCount++;
					consonantsCount = 0;
					
					if (vowelsCount == 3) {
						allowable = false;
						break;
					}

					if ((vowelsCount == 2)) {
						if (lastCharacter.equals(chr) && !(chr.equals('o') || chr.equals('e'))) {
							allowable = false;
							break;
						}
					}
					lastCharacter = chr;
				}
				else {
					vowelsCount=0;
					consonantsCount++;

					if (consonantsCount == 2 && lastCharacter.equals(chr)) {
						allowable = false;
						break;
					}

					if (consonantsCount == 3) {
						allowable = false;
						break;
					}

					lastCharacter = chr;
				}
			}

			if (hasVowel == false || allowable == false) {
				sb.append("<").append(str).append(">").append(" is not acceptable.\n");
			}
			else {
				sb.append("<").append(str).append(">").append(" is acceptable.\n");
			}

		}

		System.out.println(sb);
	}
	
}