package com.adrielm.aoc2020.solutions.day08

import com.adrielm.aoc2020.common.toPair
import kotlin.properties.Delegates

class InstructionSet() {
    var instruction by Delegates.notNull<Instruction>()
        private set
    var number by Delegates.notNull<Int>()
        private set

    constructor(
        instructionData: String
    ) : this() {
        val instructionSplit = instructionData.toPair(
            delimiter = " ",
            firstTransformer = { f -> Instruction.valueOf(f.toUpperCase()) },
            secondTransformer = { s -> s.toInt() }
        )
        instruction = instructionSplit.first
        number = instructionSplit.second
    }

    constructor(
        instruction2: Instruction,
        number2: Int
    ) : this() {
        instruction = instruction2
        number = number2
    }

    fun withNewInstruction(newInstruction: Instruction): InstructionSet {
        return InstructionSet(newInstruction, number)
    }
}
