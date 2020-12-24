package com.adrielm.aoc2020.test_utils

import com.adrielm.app.AppModule
import org.junit.Rule
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTestRule

abstract class BaseTest : AutoCloseKoinTest() {
    @get:Rule
    val rule = KoinTestRule.create {
        modules(AppModule.modules)
    }
}
