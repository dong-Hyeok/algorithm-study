package main.programmers.완전범죄;
import java.util.*;
public class 완전범죄 {

    static final int INF = 999999;
    static int[][] info;
    static int n, m;
    static int[][][] dp;
    public static void main(String[] args) {
        info = new int[][] { {1, 2}, {2, 3}, {2, 1} };
        n = 4;
        m = 4;

        int result = solution(info, n, m);
        System.out.println("결과: " + result);
    }

    static int solution(int[][] info, int n, int m) {
        int len = info.length;

        // A는 n 이상이면 실패, B는 m 이상이면 실패
        dp = new int[len + 1][n][m];  // 최대 (n-1), (m-1)
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int result = dfs(0, 0, 0);
        return result == INF ? -1 : result;
    }

    static int dfs(int i, int a, int b) {
        if (a >= n || b >= m) return INF;
        if (i == info.length) return a;

        if (dp[i][a][b] != -1) return dp[i][a][b];

        int caseA = dfs(i + 1, a + info[i][0], b);
        System.out.println("A: "+ i + " " + (a + info[i][0]) + " " + b + " : " + caseA);
        int caseB = dfs(i + 1, a, b + info[i][1]);
        System.out.println("B: "+ i + " " + a + " " + (b + info[i][1]) + " : " + caseB);


        return dp[i][a][b] = Math.min(caseA, caseB);
    }
}
