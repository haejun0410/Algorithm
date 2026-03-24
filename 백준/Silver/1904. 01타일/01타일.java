import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] dp = new int[1000001]; 
        
        dp[1] = 1; // 길이가 1일 때: "1"
        dp[2] = 2; // 길이가 2일 때: "00", "11"
        
        for(int i = 3; i <= n; i++) {
        	// dp[i-2]에 "00"을 붙이기 or dp[i-1]에 "1"을 붙이기
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        
        System.out.println(dp[n]);
    }
}