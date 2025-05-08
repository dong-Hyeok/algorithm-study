package main.baekjoon.움직이는_미로_탈출_16954;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// {-1,-1} {-1,0} {-1,1}
// {0,-1} {0,0} {0,1}
// {1,-1} {1,0} {1,1}
public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static char[][] board = new char[8][8];
    static char[][][] boardList = new char[9][8][8];
    static int[] sp = {7,0};
    static int[] ep = {0,7};
    static int[] moveY = {-1,-1,-1,0,1,1,1,0,0};
    static int[] moveX = {-1,0,1,1,1,0,-1,-1,0};

    static int result = 0;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        start();

        System.out.println(result);
    }

    static void init() throws Exception {
        for(int i=0; i<8; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void start() {
        makeBoardList();
        dfs(sp[0], sp[1], 0);
    }

    static void dfs(int y, int x, int moveCnt) {
        if(result == 1) return;

        if(moveCnt > 7 || y == ep[0] && x == ep[1]) {
            result = 1;
            return;
        }

        if(boardList[moveCnt][y][x] == '#') {
            return;
        }

        for(int i=0; i<moveX.length; i++) {
            int toY = y + moveY[i];
            int toX = x + moveX[i];

            if(toY < 8 && toY >=0 && toX < 8 && toX >= 0 && moveCnt < 8) {
                if(boardList[moveCnt][toY][toX] != '#') {
                    dfs(toY, toX, moveCnt+1);
                }
            }
        }
    }

    static void makeBoardList() {
        boardList[0] = board;

        for(int i=0; i<board.length; i++) {
            char[][] newBoard = new char[8][8];

            for(int j=0; j< board.length-1; j++) {
                newBoard[j+1] = boardList[i][j];
            }
            for(int j=0; j< board.length; j++) {
                newBoard[0][j] = '.';
            }

            boardList[i+1] = newBoard;
        }
    }
}
