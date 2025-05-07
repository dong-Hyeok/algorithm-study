package main.baekjoon.사탕_게임_3085;
import java.io.*;

public class 사탕_게임 {

    static BufferedReader br;
    static StringBuilder sb;
    static int[] MY = {0 , 0, 1, -1};
    static int[] MX = {1 , -1, 0, 0};

    static int n;
    static char[][] board;
    static int maxCount;

    public static void  main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        start();
        System.out.println(maxCount);
    }

    static void init() throws Exception {
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i=0; i<n; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void start() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                changePosi(i, j);
            }
        }
    }

    // 현재 중심(y,x)기준 상하좌우 값 변경 및 최대값 탐색
    static void changePosi(int y, int x) {
        for(int i=0; i<4; i++) {
            int targetY = MY[i] + y;
            int targetX = MX[i] + x;

            if(targetY < 0 || targetY >= n || targetX < 0 || targetX >= n) {
                continue;
            }

            char originV = board[y][x];
            board[y][x] = board[targetY][targetX];
            board[targetY][targetX] = originV;
            findMax(y, x);
            board[targetY][targetX] = board[y][x];
            board[y][x] = originV;
        }
    }

    // Y,X 축 탐색해서 최대값 찾기
    static void findMax(int y, int x) {
        char pointV = board[y][x];

        // Y 축
        int cntY = 1;
        for(int i=y+1; i<n; i++) {
            if(board[i][x] == pointV) cntY++;
            else break;
        }
        for(int i=y-1; i>=0; i--) {
            if(board[i][x] == pointV) cntY++;
            else break;
        }

        // X 축
        int cntX = 1;
        for(int i=x+1; i<n; i++) {
            if(board[y][i] == pointV) cntX++;
            else break;
        }
        for(int i=x-1; i>=0; i--) {
            if(board[y][i] == pointV) cntX++;
            else break;
        }

        maxCount = Math.max(maxCount, Math.max(cntY, cntX));
    }
}
