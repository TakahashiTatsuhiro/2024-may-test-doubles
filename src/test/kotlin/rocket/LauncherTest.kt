package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LauncherTest {
    @Test
    fun givenExpiredLaunchCodes_RocketIsNotLaunched_Spy() {
        // arrange - 準備
        val rocket = SpyRocket()

        // act - 実行
        Launcher.launchRocket(rocket, ExpiredLaunchCode())

        // assert - 確認
        assertFalse(rocket.launchWasCalled())
        assertTrue(rocket.disableWasCalled())
    }

    @Test
    fun givenUnsignedLaunchCodes_RocketIsNotLaunched_Spy() {
        // arrange - 準備
        val rocket = SpyRocket()

        // act - 実行
        Launcher.launchRocket(rocket, UnsignedLaunchCode())

        // assert - 確認
        assertFalse(rocket.launchWasCalled())
        assertTrue(rocket.disableWasCalled())
    }

    @Test
    fun givenExpiredLaunchCodes_MissileIsNotLaunched_Mock() {
        val mockRocket = MockRocket()

        Launcher.launchRocket(mockRocket, ExpiredLaunchCode())

        mockRocket.verifyCodeRedAbort()
    }

    @Test
    fun givenUnsignedLaunchCodes_MissileIsNotLaunched_Mock() {
        val mockRocket = MockRocket()

        Launcher.launchRocket(mockRocket, UnsignedLaunchCode())

        mockRocket.verifyCodeRedAbort()
    }

    @Test
    fun givenGoodLaunchCodes_RocketIsLaunched() {
        // arrange - 準備
        val rocket = SpyRocket()

        // act - 実行
        Launcher.launchRocket(rocket, GoodLaunchCode())

        // assert - 確認
        assertTrue(rocket.launchWasCalled())
        assertFalse(rocket.disableWasCalled())
    }
}