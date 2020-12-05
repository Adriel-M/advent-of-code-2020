package day01

import common.Utils
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.dsl.module
import common.Solution

class Day01 : Solution(1), KoinComponent {
    private val utils: Utils by inject()
    private val twoSum: TwoSum by inject()
    private val threeSum: ThreeSum by inject()

    override fun problem1(): Int {
        val numbers = utils.resourceToIntList("day01.txt")
        val (a, b) = twoSum.find(numbers, 2020)!!
        return a * b
    }

    override fun problem2(): Int {
        val numbers = utils.resourceToIntList("day01.txt")
        val (a, b, c) = threeSum.find(numbers, 2020)!!
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