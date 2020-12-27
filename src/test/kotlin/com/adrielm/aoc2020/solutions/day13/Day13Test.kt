package com.adrielm.aoc2020.solutions.day13

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day13Test : BaseTest(13) {
    private val day13: Day13 by inject()
    private val busScheduleParser: BusScheduleParser by inject()

    private val fileInput = FileUtils.fileToList(fileName)

    override fun `example problem 1`() {
        assertThat(
            day13.solveProblem1(
                Day13.Input(
                    939,
                    busScheduleParser.parse("7,13,x,x,59,x,31,19")
                )
            )
        ).isEqualTo(295L)
    }

    override fun `input problem 1`() {
        val start = fileInput.first().toInt()
        val schedules = busScheduleParser.parse(fileInput[1])

        assertThat(
            day13.solveProblem1(
                Day13.Input(
                    start,
                    schedules
                )
            )
        ).isEqualTo(4207L)
    }

    override fun `example problem 2`() {
        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("7,13,x,x,59,x,31,19")
                )
            )
        ).isEqualTo(1068781L)

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("17,x,13,19")
                )
            )
        ).isEqualTo(3417L)

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("67,7,59,61")
                )
            )
        ).isEqualTo(754018L)

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("67,x,7,59,61")
                )
            )
        ).isEqualTo(779210L)

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("67,7,x,59,61")
                )
            )
        ).isEqualTo(1261476L)

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    939,
                    busScheduleParser.parse("1789,37,47,1889")
                )
            )
        ).isEqualTo(1202161486L)
    }

    override fun `input problem 2`() {
        val start = fileInput.first().toInt()
        val schedules = busScheduleParser.parse(fileInput[1])

        assertThat(
            day13.solveProblem2(
                Day13.Input(
                    start,
                    schedules
                )
            )
        ).isEqualTo(725850285300475L)
    }
}
