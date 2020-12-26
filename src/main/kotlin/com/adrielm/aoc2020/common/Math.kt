package com.adrielm.aoc2020.common

import kotlin.math.cos
import kotlin.math.sin

object Math {
    fun calculateCartesianOffset(directionAngle: Int, magnitude: Int): CoordinatePair {
        val normalizedAngle = directionAngle % 360
        val quarterAngle = normalizedAngle % 90

        val movement1 = cos(quarterAngle.toDouble()) * magnitude
        val movement2 = sin(quarterAngle.toDouble()) * magnitude

        return when (normalizedAngle / 90) {
            0 -> CoordinatePair(movement1, movement2)
            1 -> CoordinatePair(-movement2, movement1)
            2 -> CoordinatePair(-movement1, -movement2)
            else -> CoordinatePair(movement2, -movement1)
        }
    }

    // rotation counter clockwise
    fun simpleRotation(coordinate: CoordinatePair, rotation: Int): CoordinatePair {
        val (newX, newY) = when (rotation) {
            0 -> Pair(coordinate.X, coordinate.Y)
            90 -> Pair(-coordinate.Y, coordinate.X)
            180 -> Pair(-coordinate.X, -coordinate.Y)
            270 -> Pair(coordinate.Y, -coordinate.X)
            else -> throw IllegalArgumentException("Invalid rotation")
        }
        return CoordinatePair(newX, newY)
    }

    data class CoordinatePair(
        val X: Double,
        val Y: Double,
    )
}
