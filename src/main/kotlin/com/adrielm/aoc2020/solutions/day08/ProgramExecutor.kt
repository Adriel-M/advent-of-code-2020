package com.adrielm.aoc2020.solutions.day08

class ProgramExecutor(
    private val instructions: List<InstructionSet>
) {
    var accumulator = 0
    private var currentLine = 0
    private val visited = mutableSetOf<Int>()

    fun execute(): Boolean {
        while (currentLine < instructions.size) {
            if (shouldHalt()) return false
            visited.add(currentLine)
            executeLine()
        }
        return true
    }

    private fun shouldHalt(): Boolean {
        return currentLine in visited
    }

    private fun executeLine() {
        val currentAction = instructions[currentLine]

        when (currentAction.instruction) {
            Instruction.ACC -> {
                accumulator += currentAction.number
                currentLine++
            }
            Instruction.JMP -> currentLine += currentAction.number
            else -> currentLine++
        }
    }
}
