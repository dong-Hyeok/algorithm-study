package main.baekjoon.수열의_합;
import java.io.*;
import java.util.*;
public class 수열의_합 {

    static BufferedReader br;
    static StringBuilder sb;
    static int N, L;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
        start();

        System.out.println(sb.toString());
    }

    static void init() throws Exception {
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        L = Integer.parseInt(str[1]);
    }

    static void start() {
        while(true) {
            int sumL = 0;
            for(int i=0; i<L; i++) sumL += i;

            if(sumL > N || L > 100) {
                sb.append(-1);
                break;
            }

            // 나머지가 발생하면 L을 증가 후 다시 시도
            if((N-sumL) % L != 0) {
                L++;
                continue;
            }

            // 몫이 배열의 첫 번째 값이 됨
            int first = (N-sumL) / L;
            for(int i=0; i < L; i++) {
                int value = first + i;
                sb.append(value + " ");
            }

            break;
        }
    }
}
