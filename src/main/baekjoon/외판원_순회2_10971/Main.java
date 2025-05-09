package main.baekjoon.외판원_순회2_10971;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static int[][] map;
    static int[] visit;
    static int minCost = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        start();
        System.out.println(minCost);
    }

    static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
    }


    static void start() {
        // 0: 미방문, 1: 방문, 2: 출발점
        visit = new int[N];

        for(int i=0; i<N; i++) {
            visit[i] = 2;
            dfs(i,0);
            visit[i] = 0;
        }
    }

    static void dfs(int from, int cost) {
        if(cost > minCost) return;

        for(int i=0; i<N; i++) {
            // 현재 도시는 제외 && 갈 수 있는 경로인 경우
            if(from == i || map[from][i] == 0) continue;

            // 모두 방문했고 && 마지막 도착지가 출발점인 경우
            if(isAllVisit() && visit[i] == 2) {
//                System.out.println(Arrays.toString(visit) + " / cost: "+ cost + map[from][i]);
                minCost = Math.min(minCost, cost + map[from][i]);
                return;
            }
            // 아직 방문하지 않았고
            else if(visit[i] == 0 && map[from][i] != 0) {
                    visit[i] = 1;
                    dfs(i, cost + map[from][i]);
                    visit[i] = 0;
            }
        }
    }

    static boolean isAllVisit() {
        for(int i=0; i<N; i++) {
            if(visit[i] == 0) return false;
        }

        return true;
    }

}
