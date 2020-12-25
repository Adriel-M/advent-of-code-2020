package com.adrielm.aoc2020.solutions.day06

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day06 : Solution<List<List<String>>, Int>(6) {
    override fun solveProblem1(input: List<List<String>>): Int {
        return input.sumBy { group ->
            val answeredYesTo = mutableSetOf<Char>()
            for (individual in group) {
                for (answer in individual) {
                    answeredYesTo.add(answer)
                }
            }
            answeredYesTo.size
        }
    }

    override fun solveProblem2(input: List<List<String>>): Int {
        return input.sumBy { group ->
            group.asSequence()
                .map { it.toSet() }
                .reduce { answeredYesTo, currentAnswers ->
                    answeredYesTo.intersect(currentAnswers)
                }.size
        }
    }

    companion object {
        val module = module {
            single { Day06() }
        }
    }
}
