package test_utils

import app.AppModule
import org.junit.Rule
import org.koin.test.AutoCloseKoinTest
import org.koin.test.KoinTestRule

abstract class BaseTest : AutoCloseKoinTest() {
    @get:Rule
    val rule = KoinTestRule.create {
        modules(AppModule.modules)
    }
}
