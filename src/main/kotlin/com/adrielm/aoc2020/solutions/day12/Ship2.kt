package com.adrielm.aoc2020.solutions.day12

import com.adrielm.aoc2020.common.Math.CoordinatePair
import com.adrielm.aoc2020.common.Math.simpleRotation

class Ship2(
    instructions: List<Instruction>
) : BaseShip(instructions) {
    private var waypointX = 10
    private var waypointY = 1

    override fun runN(instruction: Instruction) {
        waypointY += instruction.number
    }

    override fun runS(instruction: Instruction) {
        waypointY -= instruction.number
    }

    override fun runE(instruction: Instruction) {
        waypointX += instruction.number
    }

    override fun runW(instruction: Instruction) {
        waypointX -= instruction.number
    }

    override fun runL(instruction: Instruction) {
        rotateWaypoint(Math.floorMod(instruction.number, 360))
    }

    override fun runR(instruction: Instruction) {
        rotateWaypoint(Math.floorMod(-instruction.number, 360))
    }

    override fun runF(instruction: Instruction) {
        shipX += (instruction.number * waypointX)
        shipY += (instruction.number * waypointY)
    }

    private fun rotateWaypoint(angle: Int) {
        val rotatedCoordinates = simpleRotation(CoordinatePair(waypointX.toDouble(), waypointY.toDouble()), angle)
        waypointX = rotatedCoordinates.X.toInt()
        waypointY = rotatedCoordinates.Y.toInt()
    }
}
