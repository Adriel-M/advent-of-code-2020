package com.adrielm.aoc2020.solutions.day01

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.BeforeClass
import org.koin.test.inject

class Day01Test : BaseTest() {
    private val day01: Day01 by inject()

    private val exampleInput = listOf(
        1721,
        979,
        366,
        299,
        675,
        1456,
    )

    override fun `example problem 1`() {
        assertThat(day01.solveProblem1(exampleInput)).isEqualTo(514579)
    }

    override fun `input problem 1`() {
        assertThat(day01.solveProblem1(fileInput)).isEqualTo(299299)
    }

    override fun `example problem 2`() {
        assertThat(day01.solveProblem2(exampleInput)).isEqualTo(241861950)
    }

    override fun `input problem 2`() {
        assertThat(day01.solveProblem2(fileInput)).isEqualTo(287730716)
    }

    companion object {
        lateinit var fileInput: List<Int>

        @BeforeClass
        @JvmStatic
        fun classSetup() {
            fileInput = FileUtils.resourceToIntList("day01.txt")
        }
    }
}
