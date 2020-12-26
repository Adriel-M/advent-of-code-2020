package com.adrielm.aoc2020.solutions.day12

class InstructionParser {
    fun parse(instructionData: String): Instruction {
        val action = Instruction.Action.valueOf(instructionData[0].toString())
        val number = instructionData.drop(1).toInt()
        return Instruction(
            action = action,
            number = number
        )
    }
}
