package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class LauncherTest {

    @Test
    fun givenExpiredLaunchCodes_RocketIsNotLaunched_Dummy() {
        Launcher.launchRocket(DummyRocket(), ExpiredLaunchCode())
    }

    @Test
    fun givenExpiredLaunchCodes_RocketIsNotLaunched_Spy() {
        // arrange - 準備
        val rocket: SpyRocket = SpyRocket()

        // act - 実行
        Launcher.launchRocket(rocket, ExpiredLaunchCode())

        // assert - 確認
        assertFalse(rocket.launchWasCalled())
    }
}