package com.adrielm.aoc2020.solutions.day12

import com.adrielm.aoc2020.common.Math.calculateCartesianOffset

class Ship1(
    instructions: List<Instruction>
) : BaseShip(instructions) {
    private var currentDirection = 0

    override fun runN(instruction: Instruction) {
        shipY += instruction.number
    }

    override fun runS(instruction: Instruction) {
        shipY -= instruction.number
    }

    override fun runE(instruction: Instruction) {
        shipX += instruction.number
    }

    override fun runW(instruction: Instruction) {
        shipX -= instruction.number
    }

    override fun runL(instruction: Instruction) {
        currentDirection = Math.floorMod(currentDirection + instruction.number, 360)
    }

    override fun runR(instruction: Instruction) {
        currentDirection = Math.floorMod(currentDirection - instruction.number, 360)
    }

    override fun runF(instruction: Instruction) {
        val movement = calculateCartesianOffset(currentDirection, instruction.number)
        val xMovement = movement.X.toInt()
        val yMovement = movement.Y.toInt()
        shipX += xMovement
        shipY += yMovement
    }
}
