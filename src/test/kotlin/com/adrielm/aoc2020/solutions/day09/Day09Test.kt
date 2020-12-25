package com.adrielm.aoc2020.solutions.day09

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day09Test : BaseTest() {
    private val day09: Day09 by inject()

    override fun `example problem 1`() {
        val example = listOf(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127,
            219,
            299,
            277,
            309,
            576,
        ).map { it.toLong() }
        assertThat(
            day09.solveProblem1(
                Day09.Input(
                    preambleSize = 5,
                    numbers = example
                )
            )
        ).isEqualTo(127)
    }

    override fun `input problem 1`() {
        val fileInput = FileUtils.fileToList("day09.txt") { it.toLong() }
        assertThat(
            day09.solveProblem1(
                Day09.Input(
                    preambleSize = 25,
                    numbers = fileInput
                )
            )
        ).isEqualTo(675280050L)
    }

    override fun `example problem 2`() {
        val example = listOf(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127,
            219,
            299,
            277,
            309,
            576,
        ).map { it.toLong() }
        assertThat(
            day09.solveProblem2(
                Day09.Input(
                    preambleSize = 5,
                    numbers = example
                )
            )
        ).isEqualTo(62)
    }

    override fun `input problem 2`() {
        val fileInput = FileUtils.fileToList("day09.txt") { it.toLong() }
        assertThat(
            day09.solveProblem2(
                Day09.Input(
                    preambleSize = 25,
                    numbers = fileInput
                )
            )
        ).isEqualTo(96081673L)
    }
}
