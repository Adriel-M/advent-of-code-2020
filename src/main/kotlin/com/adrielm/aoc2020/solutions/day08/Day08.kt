package com.adrielm.aoc2020.solutions.day08

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day08 : Solution<List<InstructionSet>, Int>(8) {
    override fun solveProblem1(input: List<InstructionSet>): Int {
        val program = ProgramExecutor(input)
        program.execute()
        return program.accumulator
    }

    override fun solveProblem2(input: List<InstructionSet>): Int {
        val mutableInput = input.toMutableList()
        for ((i, currentInstruction) in mutableInput.withIndex()) {
            when (currentInstruction.instruction) {
                Instruction.ACC -> continue
                Instruction.JMP -> {
                    val newInstruction = currentInstruction.withNewInstruction(Instruction.NOP)
                    mutableInput[i] = newInstruction
                }
                Instruction.NOP -> {
                    val newInstruction = currentInstruction.withNewInstruction(Instruction.JMP)
                    mutableInput[i] = newInstruction
                }
            }
            val program = ProgramExecutor(mutableInput)
            if (program.execute()) {
                return program.accumulator
            }
            mutableInput[i] = currentInstruction
        }
        return -1
    }

    companion object {
        val module = module {
            single { Day08() }
        }
    }
}
