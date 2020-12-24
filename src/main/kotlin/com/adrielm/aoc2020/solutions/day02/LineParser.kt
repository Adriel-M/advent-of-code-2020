package com.adrielm.aoc2020.solutions.day02

import com.adrielm.aoc2020.common.toPair

class LineParser {
    fun parse(line: String): PasswordTester {
        val lineSplit = line.split(":")
        val policy = parsePolicy(lineSplit[0])
        val password = parsePassword(lineSplit[1])
        return PasswordTester(policy, password)
    }

    private fun parsePassword(passwordSplit: String): String {
        return passwordSplit.trim()
    }

    private fun parsePolicy(policySplit: String): CharacterPolicy {
        val split = policySplit.trim().split(" ")
        return CharacterPolicy(
            char = split[1].first(),
            lowerUpper = split[0].toPair { it.toInt() }.toLowerUpper()
        )
    }
}

private fun Pair<Int, Int>.toLowerUpper(): LowerUpper {
    return LowerUpper(
        lower = this.first,
        upper = this.second
    )
}
