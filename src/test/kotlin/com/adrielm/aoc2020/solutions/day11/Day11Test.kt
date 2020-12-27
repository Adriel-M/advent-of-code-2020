package com.adrielm.aoc2020.solutions.day11

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day11Test : BaseTest(11) {
    private val day11: Day11 by inject()

    private val fileInput = FileUtils.fileToList(fileName) { it.toList() }

    private val exampleInput =
        """
            L.LL.LL.LL
            LLLLLLL.LL
            L.L.L..L..
            LLLL.LL.LL
            L.LL.LL.LL
            L.LLLLL.LL
            ..L.L.....
            LLLLLLLLLL
            L.LLLLLL.L
            L.LLLLL.LL
        """.trimIndent()
            .lines()
            .map { it.toList() }

    override fun `example problem 1`() {
        assertThat(day11.solveProblem1(exampleInput)).isEqualTo(37)
    }

    override fun `input problem 1`() {
        assertThat(day11.solveProblem1(fileInput)).isEqualTo(2361)
    }

    override fun `example problem 2`() {
        assertThat(day11.solveProblem2(exampleInput)).isEqualTo(26)
    }

    override fun `input problem 2`() {
        assertThat(day11.solveProblem2(fileInput)).isEqualTo(2119)
    }
}
