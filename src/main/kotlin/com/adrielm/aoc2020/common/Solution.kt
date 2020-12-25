package com.adrielm.aoc2020.common

import org.koin.core.KoinComponent

abstract class Solution<I, O>(
    private val problemNumber: Int
) : KoinComponent {
    abstract fun solveProblem1(input: I): O
    abstract fun solveProblem2(input: I): O
}
