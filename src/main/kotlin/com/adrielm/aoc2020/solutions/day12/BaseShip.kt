package com.adrielm.aoc2020.solutions.day12

abstract class BaseShip(
    private val instructions: List<Instruction>
) {
    var shipX = 0
    var shipY = 0

    fun run() {
        for (instruction in instructions) {
            when (instruction.action) {
                Instruction.Action.N -> runN(instruction)
                Instruction.Action.S -> runS(instruction)
                Instruction.Action.E -> runE(instruction)
                Instruction.Action.W -> runW(instruction)
                Instruction.Action.L -> runL(instruction)
                Instruction.Action.R -> runR(instruction)
                Instruction.Action.F -> runF(instruction)
            }
        }
    }

    protected abstract fun runN(instruction: Instruction)
    protected abstract fun runS(instruction: Instruction)
    protected abstract fun runE(instruction: Instruction)
    protected abstract fun runW(instruction: Instruction)
    protected abstract fun runL(instruction: Instruction)
    protected abstract fun runR(instruction: Instruction)
    protected abstract fun runF(instruction: Instruction)
}
