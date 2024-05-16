package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import kotlin.test.assertTrue

class MockRocket: Rocket {
    private var launchWasCalled = false
    private var disableWasCalled = false

    override fun launch() {
        launchWasCalled = true
    }

    override fun disable() {
        disableWasCalled = true
    }

    fun verifyCodeRedAbort() {
        assertFalse(launchWasCalled)
        assertTrue(disableWasCalled)
    }

    fun verifyLaunch() {
        assertTrue(launchWasCalled)
        assertFalse(disableWasCalled)
    }
}
