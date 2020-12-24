package com.adrielm.aoc2020.app

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class Main {
    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            startKoin {
                printLogger()
                modules(AppModule.modules)
            }
            stopKoin()
        }
    }
}
