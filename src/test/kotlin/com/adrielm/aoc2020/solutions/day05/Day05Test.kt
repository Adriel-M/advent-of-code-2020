package com.adrielm.aoc2020.solutions.day05

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day05Test : BaseTest(5) {
    private val day05: Day05 by inject()

    private val exampleSeats = listOf(
        Seat("BFFFBBFRRR"),
        Seat("FFFBBBFRRR"),
        Seat("BBFFBBFRLL"),
    )

    private val fileInput = FileUtils.fileToList(resourceName) { Seat(it) }

    override fun `example problem 1`() {
        assertThat(day05.solveProblem1(exampleSeats)).isEqualTo(820)
    }

    override fun `input problem 1`() {
        assertThat(day05.solveProblem1(fileInput)).isEqualTo(874)
    }

    override fun `input problem 2`() {
        assertThat(day05.solveProblem2(fileInput)).isEqualTo(594)
    }
}
