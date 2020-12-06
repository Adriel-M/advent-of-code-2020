package day01

import common.Solution
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module

class Day01 : Solution<List<Int>, Int>(1), KoinComponent {
    private val twoSum: TwoSum by inject()
    private val threeSum: ThreeSum by inject()

    override fun solveProblem1(input: List<Int>): Int {
        val (a, b) = twoSum.find(input, 2020)!!
        return a * b
    }

    override fun solveProblem2(input: List<Int>): Int {
        val (a, b, c) = threeSum.find(input, 2020)!!
        return a * b * c
    }

    companion object {
        val module = module {
            single { Day01() }
            single { TwoSum() }
            single { ThreeSum() }
        }
    }
}
