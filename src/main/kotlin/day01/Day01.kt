package day01

import common.Algorithms
import common.Solution
import org.koin.core.KoinComponent
import org.koin.dsl.module

class Day01 : Solution<List<Int>, Int>(1), KoinComponent {
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
