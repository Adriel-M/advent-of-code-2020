package com.adrielm.aoc2020.solutions.day06

import com.adrielm.aoc2020.common.CollectionUtils
import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day06Test : BaseTest(6) {
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
    private val exampleCustomsAnswers = CollectionUtils.partitionLinesByEmptySpace(exampleInput.lines())

    private val fileInput = CollectionUtils.partitionLinesByEmptySpace(
        FileUtils.fileToList(fileName)
    )

    override fun `example problem 1`() {
        assertThat(day06.solveProblem1(exampleCustomsAnswers)).isEqualTo(11)
    }

    override fun `input problem 1`() {
        assertThat(day06.solveProblem1(fileInput)).isEqualTo(6799)
    }

    override fun `example problem 2`() {
        assertThat(day06.solveProblem2(exampleCustomsAnswers)).isEqualTo(6)
    }

    override fun `input problem 2`() {
        assertThat(day06.solveProblem2(fileInput)).isEqualTo(3354)
    }
}
