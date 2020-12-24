package com.adrielm.aoc2020.solutions.day05

import com.adrielm.aoc2020.common.Utils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.koin.test.inject

class Day05Test : BaseTest() {
    private val day05: Day05 by inject()

    private val exampleSeats = listOf(
        Seat("BFFFBBFRRR"),
        Seat("FFFBBBFRRR"),
        Seat("BBFFBBFRLL"),
    )

    @Test
    fun `example problem 1`() {
        assertThat(day05.solveProblem1(exampleSeats)).isEqualTo(820)
    }

    @Test
    fun `input problem 1`() {
        val fileInput = Utils.fileToList("day05.txt") { Seat(it) }
        assertThat(day05.solveProblem1(fileInput)).isEqualTo(874)
    }

    @Test
    fun `input problem 2`() {
        val fileInput = Utils.fileToList("day05.txt") { Seat(it) }
        assertThat(day05.solveProblem2(fileInput)).isEqualTo(594)
    }
}
