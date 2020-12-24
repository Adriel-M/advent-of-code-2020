package com.adrielm.solutions.day04

import com.adrielm.common.Solution
import org.koin.dsl.module

class Day04 : Solution<List<Passport>, Int>(4) {
    override fun solveProblem1(input: List<Passport>): Int {
        return input.count { it.isValid1() }
    }

    override fun solveProblem2(input: List<Passport>): Int {
        return input.count { it.isValid2() }
    }

    companion object {
        val module = module {
            single { Day04() }
            single { PassportAccumulator() }
        }
    }
}
