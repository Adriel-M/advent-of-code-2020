package com.adrielm.aoc2020.solutions.day04

import com.adrielm.aoc2020.common.safeEnumValueOf
import com.adrielm.aoc2020.common.split
import com.adrielm.aoc2020.common.toPair

class Passport(
    private val passportLines: List<String>
) {
    private var profile: Map<RequiredPassportEntries, String>
    init {
        profile = parseLines()
    }

    private fun parseLines(): Map<RequiredPassportEntries, String> {
        return passportLines.asSequence()
            .flatMap { it.split() }
            .mapNotNull { parseEntry(it) }
            .associateBy({ it.first }, { it.second })
    }

    private fun parseEntry(entry: String): Pair<RequiredPassportEntries, String>? {
        val pair = entry.toPair(":") { it }
        val mappedEnum = safeEnumValueOf<RequiredPassportEntries>(pair.first.toUpperCase()) ?: return null

        return Pair(mappedEnum, pair.second)
    }

    fun isValid1(): Boolean {
        return RequiredPassportEntries.values().all { it in profile }
    }

    fun isValid2(): Boolean {
        return RequiredPassportEntries.values().all { requiredPassportEntry ->
            profile[requiredPassportEntry]?.let { requiredPassportEntry.isValid(it) } == true
        }
    }
}
