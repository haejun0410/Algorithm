import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String args[]) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int win = Integer.parseInt(st.nextToken());
        int lose = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        
        int cnt = 0;
        boolean flag = false;
        
        for(int i=0; i<N; i++) {
            String player = br.readLine();
            
            
            if(map.containsKey(player) && map.get(player).equals("W")) cnt += win;
            
            else {
                cnt -= lose;
                if(cnt <0) cnt = 0;
            }
            
            if(cnt >= G) {
                System.out.println("I AM NOT IRONMAN!!");
                flag = true;
                break;
            }
            
        }
        
        if(!flag) {
            System.out.println("I AM IRONMAN!!");
        }
        
        
    }
}