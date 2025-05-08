package main.baekjoon.괄호의_값_2504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int result = 0;
    static int value = 1; // 가중치

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        init();
    }

    static void init() throws Exception {
        Stack<Character> cst = new Stack<>();
        String str = br.readLine();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(') {
                cst.add(c);
                value *= 2;
            }
            else if(c == '[') {
                cst.add(c);
                value *= 3;
            }
            else if(c == ')') {
                if(cst.isEmpty() || cst.peek() != '(') {
                    result = 0;
                    break;
                }
                else if(i>0 && str.charAt(i-1) == '(') {
                    result += value;
                }
                cst.pop();
                value /= 2;
            }
            else if(c == ']') {
                if(cst.isEmpty() || cst.peek() != '[') {
                    result = 0;
                    break;
                }
                else if(i>0 && str.charAt(i-1) == '[') {
                    result += value;
                }
                cst.pop();
                value /= 3;
            }

            System.out.println("c: "+ c +" / stack: "+ cst);
            System.out.println("result: " + result + " / value: " + value + "\n");

        }

        if(!cst.isEmpty() || result == 0) System.out.println(0);
        else System.out.println(result);
    }
}
