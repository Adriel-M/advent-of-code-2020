package app

import day01.Day01
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdventOfCodeApp : KoinComponent {
    private val day01 by inject<Day01>()

    fun run() {
        day01.solve()
    }
}