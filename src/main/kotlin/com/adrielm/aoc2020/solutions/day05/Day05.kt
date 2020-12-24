package com.adrielm.solutions.day05

import com.adrielm.common.Solution
import org.koin.dsl.module

class Day05 : Solution<List<Seat>, Int>(5) {
    override fun solveProblem1(input: List<Seat>): Int {
        return input.asSequence()
            .map { it.getId() }
            .maxOrNull()!!
    }

    override fun solveProblem2(input: List<Seat>): Int {
        val ids = input.asSequence()
            .map { it.getId() }
            .toSet()
        for (row in 1..126) {
            for (col in 0..7) {
                val id = Seat.calculateId(row, col)
                if (id !in ids && (id - 1) in ids && (id + 1) in ids) return id
            }
        }
        return -1
    }

    companion object {
        val module = module {
            single { Day05() }
        }
    }
}
