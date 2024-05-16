package rocket

class SpyRocket : Rocket {
    private var launchWasCalled = false
    private var disableWasCalled = false

    override fun launch() {
        launchWasCalled = true
    }

    override fun disable() {
        disableWasCalled = true
    }

    fun launchWasCalled(): Boolean {
        return launchWasCalled
    }

    fun disableWasCalled(): Boolean {
        return disableWasCalled
    }
}
