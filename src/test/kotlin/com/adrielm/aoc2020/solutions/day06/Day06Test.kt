package com.adrielm.aoc2020.solutions.day06

import com.adrielm.aoc2020.common.CollectionUtils
import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day06Test : BaseTest() {
    private val day06: Day06 by inject()

    private val exampleInput =
        """
                abc

                a
                b
                c

                ab
                ac

                a
                a
                a
                a

                b
        """.trimIndent()

    private val exampleCustomsAnswers = CollectionUtils.partitionLinesByEmptySpace(exampleInput.split('\n'))

    override fun `example problem 1`() {
        assertThat(day06.solveProblem1(exampleCustomsAnswers)).isEqualTo(11)
    }

    override fun `input problem 1`() {
        val fileInput = FileUtils.fileToList("day06.txt")
        val answers = CollectionUtils.partitionLinesByEmptySpace(fileInput)
        assertThat(day06.solveProblem1(answers)).isEqualTo(6799)
    }

    override fun `example problem 2`() {
        assertThat(day06.solveProblem2(exampleCustomsAnswers)).isEqualTo(6)
    }

    override fun `input problem 2`() {
        val fileInput = FileUtils.fileToList("day06.txt")
        val answers = CollectionUtils.partitionLinesByEmptySpace(fileInput)
        assertThat(day06.solveProblem2(answers)).isEqualTo(3354)
    }
}
