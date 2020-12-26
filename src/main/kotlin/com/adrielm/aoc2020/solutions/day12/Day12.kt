package com.adrielm.aoc2020.solutions.day12

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module
import kotlin.math.abs

class Day12 : Solution<List<Instruction>, Int>(12) {
    override fun solveProblem1(input: List<Instruction>): Int {
        val ship = Ship1(input)
        ship.run()
        return abs(ship.shipX) + abs(ship.shipY)
    }

    override fun solveProblem2(input: List<Instruction>): Int {
        val ship = Ship2(input)
        ship.run()
        return abs(ship.shipX) + abs(ship.shipY)
    }

    companion object {
        val module = module {
            single { Day12() }
            single { InstructionParser() }
        }
    }
}
