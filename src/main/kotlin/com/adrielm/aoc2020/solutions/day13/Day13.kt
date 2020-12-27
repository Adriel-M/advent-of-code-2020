package com.adrielm.aoc2020.solutions.day13

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day13 : Solution<Day13.Input, Long>(13) {
    override fun solveProblem1(input: Input): Long {
        val mods = input.buses.map { input.startingTime % it.number }
        if (mods.any { it == 0 }) return 0
        val busNumberAndMod = (input.buses zip mods)
            .map { it.first.number to it.first.number - it.second }
            .minByOrNull { it.second }!!
        return (busNumberAndMod.first * busNumberAndMod.second).toLong()
    }

    override fun solveProblem2(input: Input): Long {
        val descendingBuses = input.buses.sortedByDescending { it.number }
        var currentTime = (descendingBuses.first().number - descendingBuses.first().position).toLong()
        var interval = descendingBuses.first().number.toLong()
        // try to lock in interval at each slice by calculating the common multiples between the prior numbers and self
        for (i in 1 until descendingBuses.size) {
            val currentBus = descendingBuses[i]
            while (!isInCorrectOffset(currentTime, currentBus)) {
                currentTime += interval
            }
            interval *= currentBus.number
        }

        return currentTime
    }

    private fun isInCorrectOffset(time: Long, bus: Bus): Boolean {
        return ((time + bus.position.toLong()) % bus.number.toLong()) == 0L
    }

    class Input(
        val startingTime: Int,
        val buses: List<Bus>
    )

    class Bus(
        val number: Int,
        val position: Int
    )

    companion object {
        val module = module {
            single { Day13() }
            single { BusScheduleParser() }
        }
    }
}
