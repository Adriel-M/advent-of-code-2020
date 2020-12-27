package com.adrielm.aoc2020.solutions.day02

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day02Test : BaseTest(2) {
    private val day02: Day02 by inject()
    private val lineParser: LineParser by inject()

    private val example =
        """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
        """.trimIndent()

    private val fileInput = FileUtils.fileToList(fileName) { lineParser.parse(it) }

    override fun `example problem 1`() {
        val sampleInput = example.lines().map { lineParser.parse(it) }
        assertThat(day02.solveProblem1(sampleInput)).isEqualTo(2)
    }

    override fun `input problem 1`() {
        assertThat(day02.solveProblem1(fileInput)).isEqualTo(550)
    }

    override fun `example problem 2`() {
        val sampleInput = example.lines().map { lineParser.parse(it) }
        assertThat(day02.solveProblem2(sampleInput)).isEqualTo(1)
    }

    override fun `input problem 2`() {
        assertThat(day02.solveProblem2(fileInput)).isEqualTo(634)
    }
}
