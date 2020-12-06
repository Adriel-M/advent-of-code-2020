package day02

import TestFixtures.testRule
import common.Utils
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class Day02Test : AutoCloseKoinTest() {
    @get:Rule
    val rule = testRule

    private val day02: Day02 by inject()
    private val lineParser: LineParser by inject()

    private val example =
        """
        1-3 a: abcde
        1-3 b: cdefg
        2-9 c: ccccccccc
        """.trimIndent()

    @Test
    fun `example problem 1`() {
        val sampleInput = example.lines().map { lineParser.parse(it) }
        assertThat(day02.solveProblem1(sampleInput)).isEqualTo(2)
    }

    @Test
    fun `example problem 2`() {
        val sampleInput = example.lines().map { lineParser.parse(it) }
        assertThat(day02.solveProblem2(sampleInput)).isEqualTo(1)
    }

    @Test
    fun `input problem 1`() {
        val fileInput = Utils.fileToList("day02.txt") { lineParser.parse(it) }
        assertThat(day02.solveProblem1(fileInput)).isEqualTo(550)
    }

    @Test
    fun `input problem 2`() {
        val fileInput = Utils.fileToList("day02.txt") { lineParser.parse(it) }
        assertThat(day02.solveProblem2(fileInput)).isEqualTo(634)
    }
}
