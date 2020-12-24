package com.adrielm.solutions.day04

class PassportAccumulator {
    fun getPassports(passportData: List<String>): List<Passport> {
        return passportData.fold(mutableListOf<MutableList<String>>()) { listOfLines, currentLine ->
            when {
                currentLine.isEmpty() -> listOfLines.add(mutableListOf())
                listOfLines.isEmpty() -> listOfLines.add(mutableListOf(currentLine))
                else -> listOfLines.last().add(currentLine)
            }
            listOfLines
        }
            .filter { it.isNotEmpty() }
            .map { Passport(it) }
    }
}
