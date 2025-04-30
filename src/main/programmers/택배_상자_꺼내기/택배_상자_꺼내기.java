package main.programmers.택배_상자_꺼내기;

public class 택배_상자_꺼내기 {
    public static void main(String[] args) {
        System.out.println(solution(13,3,6));
    }

    static int solution(int n, int w, int num) {
        int answer = 0;
        int h = n/w + ((n%w != 0) ? 1 : 0);
        int cnt = 1;
        int numY = 0;
        int numX = 0;
        int[][] arr = new int[h][w];
        boolean dir = true; // true 오른쪽으로 , false 왼쪽으로

        // 배열 채우기
        for(int i= h-1; i >= 0; i--) { // 세로

            if(dir) {
                for(int j = 0; j < w; j++) { // 가로(왼 -> 오)
                    if(cnt == num) {
                        numY = i;
                        numX = j;
                    }
                    arr[i][j] = cnt++;
                    if(cnt > n) break;
                }
            } else {
                for (int j = w-1; j >= 0; j--) { // // 가로(오 -> 왼)
                    if(cnt == num) {
                        numY = i;
                        numX = j;
                    }
                    arr[i][j] = cnt++;
                    if(cnt > n) break;
                }
            }

            dir = !dir;
        }

        // 박스 제거
        for(int i=numY; i>=0; i--) {
            if(arr[i][numX] != 0) answer ++;
        }

        return answer;
    }
}
