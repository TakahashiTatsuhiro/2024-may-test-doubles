package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LauncherTest {
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
        val mockRocket = MockRocket()

        // act - 実行
        Launcher.launchRocket(mockRocket, GoodLaunchCode())

        // assert - 確認
        mockRocket.verifyLaunch()
    }
}