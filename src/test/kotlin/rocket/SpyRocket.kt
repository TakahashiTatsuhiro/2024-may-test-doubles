package rocket

class SpyRocket : Rocket {
    private var launchWasCalled = false

    override fun launch() {
        launchWasCalled = true
    }

    fun launchWasCalled(): Boolean {
        return launchWasCalled
    }
}
