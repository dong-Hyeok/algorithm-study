package main.baekjoon.제곱수_찾기_1025;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제곱수_찾기 {
    static BufferedReader br;
    static StringBuilder sb;
    static int N, M;
    static long result = -1;
    static int[][] board;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        start();
        System.out.println(result);
    }

    static void init() throws Exception {
        String[] str1 = br.readLine().split(" ");
        N = Integer.parseInt(str1[0]); // 행
        M = Integer.parseInt(str1[1]); // 열

        board = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] str2 = br.readLine().split("");
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(str2[j]);
            }
        }
    }

    static void start() {

        // 모든 포인트 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                // (행, 열) 등차수열 경우 탐색
                for (int dr = -N; dr < N; dr++) { // dr: 행 인덱스의 증가량
                    for (int dc = -M; dc < M; dc++) { // dc: 열 인덱스의 증가량
                        if (dr == 0 && dc == 0) continue;

                        int r = i;
                        int c = j;
                        long num = 0;

                        // 등차수열 인덱스 위치로 이동하면서 완전 제곱수 값 검증
                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            num = num * 10 + board[r][c];

                            if (isPerfectSquare(num)) {
                                result = Math.max(result, num);
                            }

                            r += dr;
                            c += dc;
                        }
                    }
                }
            }
        }
    }

    static boolean isPerfectSquare(long num) {
        long sqrt = (long) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
