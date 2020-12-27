package com.adrielm.aoc2020.solutions.day08

import com.adrielm.aoc2020.common.FileUtils
import com.adrielm.aoc2020.test_utils.BaseTest
import org.assertj.core.api.Assertions.assertThat
import org.koin.test.inject

class Day08Test : BaseTest(8) {
    private val day08: Day08 by inject()

    private val fileInput = FileUtils.fileToList(resourceName) { InstructionSet(it) }

    override fun `example problem 1`() {
        val example =
            """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
            """.trimIndent()
        val instructions = example.lines().map { InstructionSet(it) }
        assertThat(day08.solveProblem1(instructions)).isEqualTo(5)
    }

    override fun `input problem 1`() {
        assertThat(day08.solveProblem1(fileInput)).isEqualTo(1586)
    }

    override fun `example problem 2`() {
        val example =
            """
            nop +0
            acc +1
            jmp +4
            acc +3
            jmp -3
            acc -99
            acc +1
            jmp -4
            acc +6
            """.trimIndent()
        val instructions = example.lines().map { InstructionSet(it) }
        assertThat(day08.solveProblem2(instructions)).isEqualTo(8)
    }

    override fun `input problem 2`() {
        assertThat(day08.solveProblem2(fileInput)).isEqualTo(703)
    }
}
