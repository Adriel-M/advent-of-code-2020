package com.adrielm.aoc2020.solutions.day03

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day03Test : BaseTest(3) {
    private val day03: Day03 by inject()

    private val example =
        """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()

    private val fileInput = FileUtils.fileToList(fileName)

    override fun `example problem 1`() {
        val sampleInput = example.lines()
        assertThat(day03.solveProblem1(sampleInput)).isEqualTo(7L)
    }

    override fun `input problem 1`() {
        assertThat(day03.solveProblem1(fileInput)).isEqualTo(252L)
    }

    override fun `example problem 2`() {
        val sampleInput = example.lines()
        assertThat(day03.solveProblem2(sampleInput)).isEqualTo(336L)
    }

    override fun `input problem 2`() {
        assertThat(day03.solveProblem2(fileInput)).isEqualTo(2608962048L)
    }
}
