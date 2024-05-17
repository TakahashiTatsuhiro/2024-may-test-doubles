package rocket

class SpyRocket : Rocket{
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

}
