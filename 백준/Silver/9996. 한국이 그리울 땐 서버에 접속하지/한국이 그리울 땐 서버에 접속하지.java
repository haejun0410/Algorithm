import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), "*");

        String prefix = st.nextToken(); // '*' 앞
        String suffix = st.nextToken(); // '*' 뒤

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int wordLen = word.length();

            // 단어가 prefix + suffix보다 짧으면 무조건 안 맞음
            if (wordLen < prefix.length() + suffix.length()) {
                sb.append("NE\n");
                continue;
            }

            String wordPrefix = word.substring(0, prefix.length());
            String wordSuffix = word.substring(wordLen - suffix.length());

            if (wordPrefix.equals(prefix) && wordSuffix.equals(suffix)) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}
