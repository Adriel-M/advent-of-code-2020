package com.adrielm.aoc2020.solutions.day01

import com.adrielm.aoc2020.common.Algorithms
import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day01 : Solution<List<Int>, Int>(1) {
    override fun solveProblem1(input: List<Int>): Int {
        val (a, b) = Algorithms.twoSum(input, 2020)!!
        return a * b
    }

    override fun solveProblem2(input: List<Int>): Int {
        val (a, b, c) = Algorithms.threeSum(input, 2020)!!
        return a * b * c
    }

    companion object {
        val module = module {
            single { Day01() }
        }
    }
}
