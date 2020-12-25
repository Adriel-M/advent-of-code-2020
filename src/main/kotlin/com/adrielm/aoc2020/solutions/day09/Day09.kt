package com.adrielm.aoc2020.solutions.day09

import com.adrielm.aoc2020.common.Algorithms
import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day09 : Solution<Day09.Input, Long>(9) {
    override fun solveProblem1(input: Input): Long {
        return getInvalidNumber(input)
    }

    override fun solveProblem2(input: Input): Long {
        val invalidNumber = getInvalidNumber(input)
        var leftPointer = 0
        var currentSum = 0L
        for ((rightPointer, currentNumber) in input.numbers.withIndex()) {
            currentSum += currentNumber
            while (currentSum > invalidNumber && leftPointer < rightPointer) {
                currentSum -= input.numbers[leftPointer]
                leftPointer++
            }
            if (currentSum == invalidNumber) {
                val window = input.numbers.slice(leftPointer..rightPointer)
                val minValue = window.minOrNull()!!
                val maxValue = window.maxOrNull()!!
                return minValue + maxValue
            }
        }
        return -1
    }

    private fun getInvalidNumber(input: Input): Long {
        for (i in input.preambleSize..input.numbers.size) {
            Algorithms.twoSum(
                input = input.numbers.slice((i - input.preambleSize) until i),
                target = input.numbers[i]
            ) ?: return input.numbers[i]
        }
        return -1
    }

    class Input(
        val preambleSize: Int,
        val numbers: List<Long>
    )

    companion object {
        val module = module {
            single { Day09() }
        }
    }
}
