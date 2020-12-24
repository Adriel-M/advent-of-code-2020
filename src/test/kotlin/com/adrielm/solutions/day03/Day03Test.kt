package com.adrielm.solutions.day03

import com.adrielm.common.Utils
import com.adrielm.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.koin.test.inject

class Day03Test : BaseTest() {
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

    @Test
    fun `example problem 1`() {
        val sampleInput = example.lines()
        assertThat(day03.solveProblem1(sampleInput)).isEqualTo(7L)
    }

    @Test
    fun `example problem 2`() {
        val sampleInput = example.lines()
        assertThat(day03.solveProblem2(sampleInput)).isEqualTo(336L)
    }

    @Test
    fun `input problem 1`() {
        val fileInput = Utils.fileToList("day03.txt") { it }
        assertThat(day03.solveProblem1(fileInput)).isEqualTo(252L)
    }

    @Test
    fun `input problem 2`() {
        val fileInput = Utils.fileToList("day03.txt") { it }
        assertThat(day03.solveProblem2(fileInput)).isEqualTo(2608962048L)
    }
}
