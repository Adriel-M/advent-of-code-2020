package com.adrielm.aoc2020.solutions.day11

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day11 : Solution<List<List<Char>>, Int>(11) {
    override fun solveProblem1(input: List<List<Char>>): Int {
        var currentState = SeatingSimulator(input)
        while (true) {
            val nextState = currentState.simulate()
            if (currentState == nextState) break

            currentState = nextState
        }
        return currentState.countOccupiedSeats()
    }

    override fun solveProblem2(input: List<List<Char>>): Int {
        var currentState = SeatingSimulator(input)
        while (true) {
            val nextState = currentState.simulate2()
            if (currentState == nextState) break

            currentState = nextState
        }
        return currentState.countOccupiedSeats()
    }

    companion object {
        val module = module {
            single { Day11() }
        }
    }
}
