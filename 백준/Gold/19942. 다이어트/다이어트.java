import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] minNutrition;
    static int[][] nutrition;

    static int minCost = Integer.MAX_VALUE;
    static List<List<Integer>> answerList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        minNutrition = new int[4];
        for (int i = 0; i < 4; i++) {
            minNutrition[i] = Integer.parseInt(st.nextToken());
        }

        nutrition = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nutrition[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < (1 << n); i++) { 
            int[] sum = new int[4];
            int totalCost = 0;
            List<Integer> picked = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    for (int k = 0; k < 4; k++) {
                        sum[k] += nutrition[j][k];
                    }
                    totalCost += nutrition[j][4];
                    picked.add(j + 1); 
                }
            }

            if (isEnough(sum)) {
                if (totalCost < minCost) {
                    minCost = totalCost;
                    answerList.clear();
                    answerList.add(picked);
                } else if (totalCost == minCost) {
                    answerList.add(picked);
                }
            }
        }

        if (answerList.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answerList, (a, b) -> {
                for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return a.size() - b.size();
            });

            System.out.println(minCost);
            for (int num : answerList.get(0)) {
                System.out.print(num + " ");
            }
        }
    }

    static boolean isEnough(int[] sum) {
        for (int i = 0; i < 4; i++) {
            if (sum[i] < minNutrition[i]) {
                return false;
            }
        }
        return true;
    }
}
