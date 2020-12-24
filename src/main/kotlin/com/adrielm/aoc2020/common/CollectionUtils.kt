package com.adrielm.aoc2020.common

object CollectionUtils {
    fun partitionLinesByEmptySpace(input: List<String>): List<List<String>> {
        return input.fold(mutableListOf<MutableList<String>>()) { listOfLines, currentLine ->
            when {
                currentLine.isEmpty() -> listOfLines.add(mutableListOf())
                listOfLines.isEmpty() -> listOfLines.add(mutableListOf(currentLine))
                else -> listOfLines.last().add(currentLine)
            }
            listOfLines
        }
    }
}
