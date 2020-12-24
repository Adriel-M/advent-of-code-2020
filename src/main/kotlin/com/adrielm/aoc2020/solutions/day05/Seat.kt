package com.adrielm.solutions.day05

import com.adrielm.common.Algorithms

class Seat(
    seatIdentifier: String
) {
    private var row: Int = 0
    private var col: Int = 0

    init {
        row = calculateRow(seatIdentifier.slice(0..6))
        col = calculateCol(seatIdentifier.slice(7..9))
    }

    fun getId() = calculateId(row, col)

    private fun calculateRow(rowIdentifier: String): Int {
        return Algorithms.binarySearch(0, 127, rowIdentifier.toList()) { it == 'B' }
    }

    private fun calculateCol(colIdentifier: String): Int {
        return Algorithms.binarySearch(0, 7, colIdentifier.toList()) { it == 'R' }
    }

    companion object {
        fun calculateId(row: Int, col: Int) = (row * 8) + col
    }
}
