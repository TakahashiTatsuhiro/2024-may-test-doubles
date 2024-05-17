package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class MockRocket : Rocket {
    var launchWasCalled = false
        private  set
    var disableWasCalled = false
        private  set

    override fun launch() {
        launchWasCalled = true
    }

    override fun disable() {
        disableWasCalled = true
    }

    fun verifyAbort() {
        assertFalse(launchWasCalled)
        assertTrue (disableWasCalled)
    }

    fun verifyLaunch() {
        assertTrue(launchWasCalled)
        assertFalse(disableWasCalled)
    }
}
