import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String exp = br.readLine();

		StringBuilder temp = new StringBuilder();

		for(int i=0; i<str.length(); i++) {
			temp.append(str.charAt(i));

			if (temp.length() >= exp.length() 
			&& temp.substring(temp.length() - exp.length()).equals(exp)) {
				temp.delete(temp.length() - exp.length(), temp.length());
			}
		}

		if (temp.length() == 0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(temp.toString());
		}
	}	
}