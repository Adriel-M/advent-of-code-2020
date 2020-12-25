package com.adrielm.aoc2020.solutions.day10

import com.adrielm.aoc2020.common.Solution
import com.adrielm.aoc2020.common.sumByLong
import org.koin.dsl.module

private val POSSIBLE_JOLT_DIFFS = listOf(1, 2, 3)

class Day10 : Solution<List<Int>, Long>(10) {
    override fun solveProblem1(input: List<Int>): Long {
        val sorted = input.sorted()
        var previousNumber = 0
        val joltDifferenceCounts = mutableMapOf(
            3 to 1L // built in adapter
        )
        for (num in sorted) {
            val diff = num - previousNumber
            joltDifferenceCounts[diff] = joltDifferenceCounts.getOrDefault(diff, 0) + 1
            previousNumber = num
        }
        return joltDifferenceCounts.getOrDefault(3, 0) * joltDifferenceCounts.getOrDefault(1, 0)
    }

    override fun solveProblem2(input: List<Int>): Long {
        val inputSet = input.toSet()
        val startingValue = inputSet.maxOrNull()!! + 3

        val cache = mutableMapOf<Int, Long>()

        fun traverse(currentValue: Int): Long {
            if (currentValue in cache) return cache[currentValue]!!
            val toReturn = when {
                currentValue == 0 -> 1L
                currentValue != startingValue && currentValue !in inputSet -> 0L
                currentValue > 0 -> {
                    POSSIBLE_JOLT_DIFFS.sumByLong { traverse(currentValue - it) }
                }
                else -> 0L
            }
            cache[currentValue] = toReturn
            return toReturn
        }
        return traverse(startingValue)
    }

    companion object {
        val module = module {
            single { Day10() }
        }
    }
}
