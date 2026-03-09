import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        private InputStream in;
        private byte[] buffer = new byte[1024 * 16];
        private int pointer = 0;
        private int bufferLength = 0;

        public FastReader(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (pointer >= bufferLength) {
                pointer = 0;
                bufferLength = in.read(buffer);
                if (bufferLength <= 0) return -1;
            }
            return buffer[pointer++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c >= 0 && c <= 32) c = read();
            if (c == -1) return -1;
            boolean neg = (c == '-');
            if (neg) c = read();
            int res = 0;
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return neg ? -res : res;
        }
    }

    static class Node implements Comparable<Node> {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.b, o.b);
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);

        int n = fr.nextInt();
        if (n == -1) return;
        
        int[] aTemp = new int[n];
        for (int i = 0; i < n; i++) aTemp[i] = fr.nextInt();

        Node[] problems = new Node[n];
        for (int i = 0; i < n; i++) {
            problems[i] = new Node(aTemp[i], fr.nextInt());
        }

        Arrays.sort(problems);

        long totalA = problems[0].a;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < n - 1; i += 2) {
            pq.add(problems[i].a);
            pq.add(problems[i + 1].a);

            if (!pq.isEmpty()) {
                totalA += pq.poll();
            }
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(totalA));
        bw.newLine();
        bw.flush();
        bw.close();
    }
}