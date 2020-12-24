package com.adrielm.aoc2020.solutions.day04

import com.adrielm.aoc2020.common.CollectionUtils

class PassportAccumulator {
    fun getPassports(passportData: List<String>): List<Passport> {
        return CollectionUtils.partitionLinesByEmptySpace(passportData)
            .filter { it.isNotEmpty() }
            .map { Passport(it) }
    }
}
