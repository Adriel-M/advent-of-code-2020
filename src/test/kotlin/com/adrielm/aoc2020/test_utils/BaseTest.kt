package com.adrielm.aoc2020.test_utils

import com.adrielm.aoc2020.app.AppModule
import org.junit.Rule
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTestRule

abstract class BaseTest(
    problemNumber: Int
) : AutoCloseKoinTest() {
    private val paddedNumber = problemNumber.toString().padStart(2, '0')
    protected val resourceName = "day$paddedNumber.txt"

    @get:Rule
    val rule = KoinTestRule.create {
        modules(AppModule.modules)
    }

    @Test
    open fun `example problem 1`() = Unit

    @Test
    abstract fun `input problem 1`()

    @Test
    open fun `example problem 2`() = Unit

    @Test
    abstract fun `input problem 2`()
}
