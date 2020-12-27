package com.adrielm.aoc2020.solutions.day12

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day12Test : BaseTest(12) {
    private val day12: Day12 by inject()
    private val instructionParser: InstructionParser by inject()

    private val fileInput = FileUtils.fileToList(fileName) { instructionParser.parse(it) }

    override fun `example problem 1`() {
        val example =
            """
            F10
            N3
            F7
            R90
            F11
            """.trimIndent()
        val instructions = example.lines().map { instructionParser.parse(it) }
        assertThat(day12.solveProblem1(instructions)).isEqualTo(25)
    }

    override fun `input problem 1`() {
        assertThat(day12.solveProblem1(fileInput)).isEqualTo(904)
    }

    override fun `example problem 2`() {
        val example =
            """
            F10
            N3
            F7
            R90
            F11
            """.trimIndent()
        val instructions = example.lines().map { instructionParser.parse(it) }
        assertThat(day12.solveProblem2(instructions)).isEqualTo(286)
    }

    override fun `input problem 2`() {
        assertThat(day12.solveProblem2(fileInput)).isEqualTo(18747)
    }
}
