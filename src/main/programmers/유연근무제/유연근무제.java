package main.programmers.유연근무제;

public class 유연근무제 {

    public static void main(String[] args) {
        int[] schedules = new int[]{700, 800, 1100};
        int[][] timelogs = new int[][]{
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday = 5;

        System.out.println(solution(schedules, timelogs, startday));
    }


    static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int[] dayArr = new int[7];
        int dayIdx = 0;
        // 주말 체크
        while(dayIdx < 7) {
            dayArr[dayIdx] = startday;
            startday++;
            dayIdx++;

            if(startday > 7) startday = 1;
        }


        // 시간 체크
        for(int i=0; i<timelogs.length; i++) {
            boolean isCheck = true;

            for(int j=0; j<7; j++) {
                // 주말은 패스!
                if(dayArr[j] == 6 || dayArr[j] == 7) continue;

                if(convertTime(timelogs[i][j]) - convertTime(schedules[i])  > 10) {
                    isCheck = false;
                    break;
                }
            }


            if(isCheck) {
                answer++;
            }
        }

        return answer;
    }

    // 시간을 총 분으로 변경
    static int convertTime(int time) {
        int hour = time / 100;
        int minute = time % 100;

        return hour*60 + minute;
    }


}
