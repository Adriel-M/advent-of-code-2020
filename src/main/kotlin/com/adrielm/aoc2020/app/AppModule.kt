package com.adrielm.aoc2020.app

import com.adrielm.aoc2020.solutions.day01.Day01
import com.adrielm.aoc2020.solutions.day02.Day02
import com.adrielm.aoc2020.solutions.day03.Day03
import com.adrielm.aoc2020.solutions.day04.Day04
import com.adrielm.aoc2020.solutions.day05.Day05
import com.adrielm.aoc2020.solutions.day06.Day06

object AppModule {
    val modules = listOf(
        Day01.module,
        Day02.module,
        Day03.module,
        Day04.module,
        Day05.module,
        Day06.module,
    )
}
