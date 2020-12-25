package com.adrielm.aoc2020.solutions.day11

private val DIRECTIONS = listOf(
    Pair(-1, -1),
    Pair(-1, 0),
    Pair(-1, 1),
    Pair(0, -1),
    Pair(0, 1),
    Pair(1, -1),
    Pair(1, 0),
    Pair(1, 1)
)

class SeatingSimulator(
    private val seatingData: List<List<Char>>
) {
    fun simulate(): SeatingSimulator {
        val copy = seatingData.map { it.toMutableList() }

        iterateAll { currentRow, currentCol, _ ->
            copy[currentRow][currentCol] = calculateNextState(currentRow, currentCol, 4) { r, c ->
                countNumberOfNeighbours(r, c)
            }
        }

        return SeatingSimulator(copy)
    }

    fun simulate2(): SeatingSimulator {
        val copy = seatingData.map { it.toMutableList() }

        iterateAll { currentRow, currentCol, _ ->
            copy[currentRow][currentCol] = calculateNextState(currentRow, currentCol, 5) { r, c ->
                countNumberOfNeighbours2(r, c)
            }
        }

        return SeatingSimulator(copy)
    }

    private fun calculateNextState(
        row: Int,
        col: Int,
        neighbourTolerance: Int,
        neighbourCounter: (r: Int, c: Int) -> Int
    ): Char {
        val currentState = seatingData[row][col]
        if (currentState == Seating.FLOOR.char) return currentState

        val numberOfNeighbours = neighbourCounter(row, col)

        return when {
            currentState == Seating.EMPTY_SEAT.char && numberOfNeighbours == 0 -> Seating.OCCUPIED_SEAT.char
            currentState == Seating.OCCUPIED_SEAT.char && numberOfNeighbours >= neighbourTolerance -> {
                Seating.EMPTY_SEAT.char
            }
            else -> currentState
        }
    }

    private fun countNumberOfNeighbours(currentRow: Int, currentCol: Int): Int {
        var numberOfNeighbours = 0
        for (direction in DIRECTIONS) {
            val rowToCheck = currentRow + direction.first
            val colToCheck = currentCol + direction.second

            if (rowToCheck < 0 || rowToCheck >= seatingData.size) continue
            if (colToCheck < 0 || colToCheck >= seatingData[rowToCheck].size) continue

            if (seatingData[rowToCheck][colToCheck] == Seating.OCCUPIED_SEAT.char) numberOfNeighbours++
        }

        return numberOfNeighbours
    }

    private fun countNumberOfNeighbours2(currentRow: Int, currentCol: Int): Int {
        var numberOfNeighbours = 0
        for (direction in DIRECTIONS) {
            var magnitude = 1
            while (true) {
                val rowToCheck = currentRow + (magnitude * direction.first)
                val colToCheck = currentCol + (magnitude * direction.second)

                if (rowToCheck < 0 || rowToCheck >= seatingData.size) break
                if (colToCheck < 0 || colToCheck >= seatingData[rowToCheck].size) break

                when (seatingData[rowToCheck][colToCheck]) {
                    Seating.OCCUPIED_SEAT.char -> {
                        numberOfNeighbours++
                        break
                    }
                    Seating.EMPTY_SEAT.char -> break
                }

                magnitude++
            }
        }

        return numberOfNeighbours
    }

    fun countOccupiedSeats(): Int {
        var count = 0
        iterateAll { _, _, currentValue ->
            if (currentValue == Seating.OCCUPIED_SEAT.char) count++
        }
        return count
    }

    private inline fun iterateAll(lambda: (currentRow: Int, currentCol: Int, currentValue: Char) -> Unit) {
        for (row in seatingData.indices) {
            for (col in seatingData[row].indices) {
                lambda(row, col, seatingData[row][col])
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        return seatingData == (other as? SeatingSimulator)?.seatingData
    }

    override fun hashCode(): Int {
        return seatingData.hashCode()
    }

    override fun toString(): String {
        return seatingData.map { it.joinToString("") }.joinToString("\n")
    }
}
