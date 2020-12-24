package com.adrielm.aoc2020.common

object Algorithms {
    fun twoSum(input: List<Int>, target: Int, startingIndex: Int = 0): Pair<Int, Int>? {
        val visited = mutableSetOf<Int>()
        for (i in startingIndex until input.size) {
            val currentNumber = input[i]
            val numberToFind = target - currentNumber
            if (numberToFind in visited) {
                return Pair(numberToFind, currentNumber)
            }
            visited.add(currentNumber)
        }
        return null
    }

    fun threeSum(input: List<Int>, target: Int): Triple<Int, Int, Int>? {
        for ((i, currentNumber) in input.withIndex()) {
            val targetTwoSum = target - currentNumber
            val twoSumAnswer = twoSum(input, targetTwoSum, i + 1)
            if (twoSumAnswer != null) {
                return Triple(twoSumAnswer.first, twoSumAnswer.second, currentNumber)
            }
        }
        return null
    }

    fun <T> binarySearch(lower: Int, upper: Int, instructions: List<T>, upperDecision: (T) -> Boolean): Int {
        var currentLower = lower
        var currentUpper = upper

        for (instruction in instructions) {
            val takeUpper = upperDecision(instruction)
            val midPoint = (currentUpper + currentLower) / 2
            if (takeUpper) {
                currentLower = midPoint + 1
            } else {
                currentUpper = midPoint
            }
        }
        return currentLower
    }
}
