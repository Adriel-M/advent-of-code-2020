package com.adrielm.aoc2020.solutions.day03

import com.adrielm.aoc2020.common.Solution
import org.koin.dsl.module

class Day03 : Solution<List<String>, Long>(3) {
    private val mapping = mapOf(
        '.' to Tile.OPEN,
        '#' to Tile.TREE
    )
    override fun solveProblem1(input: List<String>): Long {
        return countTrees(input, 3, 1)
    }

    override fun solveProblem2(input: List<String>): Long {
        val movements = listOf(
            Pair(1, 1),
            Pair(3, 1),
            Pair(5, 1),
            Pair(7, 1),
            Pair(1, 2)
        )
        return movements.asSequence()
            .map { countTrees(input, it.first, it.second) }
            .reduce { acc, i -> acc * i }
    }

    private fun countTrees(input: List<String>, xMovement: Int, yMovement: Int): Long {
        var answer = 0L
        traverse(input, xMovement, yMovement) { currentTile ->
            if (mapping[currentTile] == Tile.TREE) {
                answer++
            }
        }
        return answer
    }

    private fun traverse(input: List<String>, xMovement: Int, yMovement: Int, runnable: (Char) -> Unit) {
        val inputWidth = input.first().length
        var currentY = 0
        var currentX = 0
        while (currentY < input.size) {
            runnable(input[currentY][currentX])
            currentY += yMovement
            currentX = (currentX + xMovement) % inputWidth
        }
    }

    companion object {
        val module = module {
            single { Day03() }
        }
    }
}

private enum class Tile {
    TREE,
    OPEN
}
