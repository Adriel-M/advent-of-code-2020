package com.adrielm.aoc2020.solutions.day02

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day02 : Solution<List<PasswordTester>, Int>(2) {
    override fun solveProblem1(input: List<PasswordTester>): Int {
        return input.count { it.isValidStrategy1() }
    }

    override fun solveProblem2(input: List<PasswordTester>): Int {
        return input.count { it.isValidStrategy2() }
    }

    companion object {
        val module = module {
            single { Day02() }
            single { LineParser() }
        }
    }
}
