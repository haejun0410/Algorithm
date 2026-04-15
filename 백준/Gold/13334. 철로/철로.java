import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Road implements Comparable<Road>{
        int s, e;
        public Road(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override

        public int compareTo(Road o) {
            if(this.e == o.e)
                return this.s - o.s;
            return this.e - o.e;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Road> roads = new ArrayList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            if(h <= o)
                roads.add(new Road(h, o));
            else
                roads.add(new Road(o, h));

        }
        int L = Integer.parseInt(br.readLine());
        Collections.sort(roads);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for(Road road : roads) {
            if(road.e - road.s > L)
                continue;
            pq.offer(road.s);
            while(!pq.isEmpty()) {
                if(road.e - pq.peek() <= L)
                    break;
                pq.poll();
            }
            result = Math.max(result, pq.size());
        }	
        System.out.print(result);

    }
}