package rocket

import org.junit.jupiter.api.Test

class LauncherTest {

    @Test
    fun givenExpiredLaunchCodes_RocketIsNotLaunched() {
        Launcher.launchRocket(DummyRocket(), ExpiredLaunchCode())
    }
}