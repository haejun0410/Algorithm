import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static char[][] mat = new char[4][10];
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0, j = 0; i < 4; i++, j = 0) for (char c : br.readLine().toCharArray()) mat[i][j++] = c;
        for (char c : br.readLine().toCharArray()) set.add(c);

        bw.write(String.valueOf(search()));
        bw.flush();
    }

    private static char search() {
        for (int i = 1; i < 3; i++) for (int j = 1; j < 9; j++) if (compare(i, j)) return mat[i][j];
        return ' ';
    }

    private static boolean compare(int i, int j) {
        return set.contains(mat[i][j]) && set.contains(mat[i - 1][j]) && set.contains(mat[i - 1][j + 1]) && set.contains(mat[i][j + 1]) && set.contains(mat[i + 1][j + 1]) && set.contains(mat[i + 1][j]) && set.contains(mat[i + 1][j - 1]) && set.contains(mat[i][j - 1]) && set.contains(mat[i - 1][j - 1]);
    }

}