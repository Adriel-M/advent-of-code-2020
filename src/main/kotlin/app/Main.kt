package app

import common.Utils
import day01.Day01
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class Main {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            startKoin {
                printLogger()
                modules(
                    Day01.module,
                    Utils.module
                )
            }
            AdventOfCodeApp().run()
            stopKoin()
        }
    }
}