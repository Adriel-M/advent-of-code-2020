package com.adrielm.aoc2020.solutions.day12

class Instruction(
    val action: Action,
    val number: Int
) {
    enum class Action {
        N, S, E, W, L, R, F
    }
}
