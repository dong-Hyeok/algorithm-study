package main.baekjoon.미로_탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N, M;
    static int[][] map, visit;
    static int[] moveY = {0,0,1,-1};
    static int[] moveX = {1,-1,0,0};
    static int minCnt;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        bfs();

//        for(int i=0; i<N; i++) System.out.println(Arrays.toString(visit[i]));
        System.out.println(visit[N-1][M-1]);
    }

    static void init() throws Exception {
        String[] input_1 = br.readLine().split(" ");
        N = Integer.parseInt(input_1[0]);
        M = Integer.parseInt(input_1[1]);
        map = new int[N][M];
        visit = new int[N][M];

        for(int i=0; i<N; i++) {
            String[] input_2 = br.readLine().split("");
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(input_2[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {0,0,1}); // {y,x,cnt}

        while (!dq.isEmpty()) {
            int[] out = dq.removeFirst();

            for(int i=0; i < moveY.length; i++) {
                int dy = moveY[i] + out[0];
                int dx = moveX[i] + out[1];

                if(isMove(dy, dx) && map[dy][dx] == 1 && visit[dy][dx] > out[2]+1) {
                    visit[dy][dx] = out[2] + 1;
                    dq.add(new int[] {dy, dx, out[2]+1});
                }
            }
        }
    }

    static boolean isMove(int dy, int dx) {
        if(dy >= 0 && dy < N && dx >=0 && dx < M) return true;

        return false;
    }

}
