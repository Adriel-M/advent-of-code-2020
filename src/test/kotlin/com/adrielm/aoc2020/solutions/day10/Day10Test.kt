package com.adrielm.aoc2020.solutions.day10

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day10Test : BaseTest(10) {
    private val day10: Day10 by inject()

    val fileInput = FileUtils.resourceToIntList(resourceName)

    override fun `example problem 1`() {
        val example1 = listOf(
            16,
            10,
            15,
            5,
            1,
            11,
            7,
            19,
            6,
            12,
            4,
        )
        assertThat(day10.solveProblem1(example1)).isEqualTo(35L)

        val example2 = listOf(
            28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3,
        )
        assertThat(day10.solveProblem1(example2)).isEqualTo(220L)
    }

    override fun `input problem 1`() {
        assertThat(day10.solveProblem1(fileInput)).isEqualTo(2812L)
    }

    override fun `example problem 2`() {
        val example1 = listOf(
            16,
            10,
            15,
            5,
            1,
            11,
            7,
            19,
            6,
            12,
            4,
        )
        assertThat(day10.solveProblem2(example1)).isEqualTo(8L)

        val example2 = listOf(
            28,
            33,
            18,
            42,
            31,
            14,
            46,
            20,
            48,
            47,
            24,
            23,
            49,
            45,
            19,
            38,
            39,
            11,
            1,
            32,
            25,
            35,
            8,
            17,
            7,
            9,
            4,
            2,
            34,
            10,
            3,
        )
        assertThat(day10.solveProblem2(example2)).isEqualTo(19208L)
    }

    override fun `input problem 2`() {
        assertThat(day10.solveProblem2(fileInput)).isEqualTo(386869246296064L)
    }
}
