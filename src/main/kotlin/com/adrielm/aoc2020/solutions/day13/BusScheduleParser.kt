package com.adrielm.aoc2020.solutions.day13

class BusScheduleParser {
    fun parse(scheduleData: String): List<Day13.Bus> {
        return scheduleData
            .split(",")
            .mapIndexedNotNull { index, s ->
                try {
                    Day13.Bus(s.toInt(), index)
                } catch (e: NumberFormatException) {
                    null
                }
            }
    }
}
