import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 보통 10

        for (int testCase = 1; testCase <= T; testCase++) {
            String s = br.readLine();
            int answer = 0;

            // 마디 길이는 1 ~ 10
            for (int len = 1; len <= 10; len++) {
                boolean same = true;

                // 앞 len개와 그 다음 len개 비교
                for (int i = 0; i < len; i++) {
                    if (s.charAt(i) != s.charAt(i + len)) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    answer = len;
                    break;
                }
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
