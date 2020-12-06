import app.AppModule
import org.koin.test.KoinTestRule

object TestFixtures {
    val testRule = KoinTestRule.create {
        modules(AppModule.modules)
    }
}