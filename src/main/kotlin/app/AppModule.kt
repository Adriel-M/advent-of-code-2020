package app

import day01.Day01
import day02.Day02
import day03.Day03
import day04.Day04
import day05.Day05

object AppModule {
    val modules = listOf(
        Day01.module,
        Day02.module,
        Day03.module,
        Day04.module,
        Day05.module,
    )
}
