package main.programmers.유연근무제

fun main() {
    val schedules = intArrayOf(700, 800, 1100)
    val timelogs = arrayOf(
        intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
        intArrayOf(800, 801, 805, 800, 759, 810, 809),
        intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100)
    )
    val startday = 5

    val result = solution(schedules, timelogs, startday)
    println(result)
}

fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
    var answer: Int = 0

    var dayArr = IntArray(7)
    var day = startday

    for(i in 0..6) {
        dayArr[i] = day
        day++
        if(day > 7) day = 1
    }

    for(i in timelogs.indices) {
        var isCheck = true

        for(j in 0..6) {
            if(dayArr[j] == 6 || dayArr[j] == 7) continue

            if(convertTime(timelogs[i][j]) - convertTime(schedules[i]) > 10) {
                isCheck = false
                break
            }
        }

        if(isCheck) answer++
    }

    return answer
}

fun convertTime(time: Int): Int {
    val hour = time/100
    val min = time%100

    return hour*60 + min
}