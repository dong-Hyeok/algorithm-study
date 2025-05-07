package main.baekjoon.주사위_1041;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 주사위 {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static int[] dice = new int[6];
    static int[][] connectSide = {
            {1,2,4,3},
            {0,2,5,3},
            {0,1,5,4},
            {0,1,5,4},
            {0,2,5,3},
            {1,2,4,3},
    };
    static int min_1 = Integer.MAX_VALUE, min_2 = Integer.MAX_VALUE, min_3 = Integer.MAX_VALUE;
    static long result;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();

        if(N == 1) {
            int maxNum = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=0; i< dice.length; i++) {
                maxNum = Math.max(maxNum, dice[i]);
                sum += dice[i];
            }
            System.out.print(sum - maxNum);
            return;
        }

        findMinValue();
        minValueCalculate();
        System.out.print(result);
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine());

        String[] diceInput = br.readLine().split(" ");
        for(int i=0; i<diceInput.length; i++) {
            dice[i] = Integer.parseInt(diceInput[i]);
        }
    }

    static void findMinValue() {
        // 면 1개 최솟값
        for(int i=0; i< dice.length; i++) {
            min_1 = Math.min(min_1, dice[i]);
        }

        // (연결된) 면 2개 합의 최솟값
        for(int i=0; i< dice.length; i++) {
            int  side_1 = dice[i];
            for(int j=0; j< connectSide[i].length; j++) {
                int side_2 = dice[connectSide[i][j]];

                min_2 = Math.min(min_2, (side_1 + side_2));
            }
        }

        // (3면이 모두 연결된) 면 3개 합의 최솟값
        for(int i=0; i< dice.length; i++) {
            int  side_1 = dice[i];
            for(int j=0; j< connectSide[i].length; j++) {
                int side_2 = dice[connectSide[i][j]];
                int side_3;
                if(j+1 >= connectSide[i].length) side_3 = dice[connectSide[i][0]];
                else side_3 = dice[connectSide[i][j+1]];

                min_3 = Math.min(min_3, (side_1 + side_2 + side_3));
            }
        }
    }

    static void minValueCalculate() {
        long value_3 = min_3 * 4;
        long value_2 = min_2 * (4 * (N-2) + 4 * (N-1));
        long value_1 = min_1 * ((long)(N-2) * (long)(N-2) + 4 * (long)(N-2) * (long)(N-1));
        System.out.println(min_3 + " / " + min_2 + " / " + min_1);
        System.out.println(value_3 + " / " + value_2 + " / " + value_1);
        if(value_2 < 0) value_2 = 0;
        if(value_3 < 0) value_3 = 0;
        result = value_1 + value_2 + value_3;
    }
}
