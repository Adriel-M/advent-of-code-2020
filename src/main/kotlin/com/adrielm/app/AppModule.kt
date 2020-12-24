package com.adrielm.app

import com.adrielm.solutions.day01.Day01
import com.adrielm.solutions.day02.Day02
import com.adrielm.solutions.day03.Day03
import com.adrielm.solutions.day04.Day04
import com.adrielm.solutions.day05.Day05

object AppModule {
    val modules = listOf(
        Day01.module,
        Day02.module,
        Day03.module,
        Day04.module,
        Day05.module,
    )
}
