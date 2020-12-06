package day01

import org.koin.core.KoinComponent
import org.koin.core.inject

class ThreeSum : KoinComponent {
    private val twoSum: TwoSum by inject()

    fun find(input: List<Int>, target: Int): Triple<Int, Int, Int>? {
        for ((i, currentNumber) in input.withIndex()) {
            val targetTwoSum = target - currentNumber
            val twoSumAnswer = twoSum.find(input, targetTwoSum, i + 1)
            if (twoSumAnswer != null) {
                return Triple(twoSumAnswer.first, twoSumAnswer.second, currentNumber)
            }
        }
        return null
    }
}
