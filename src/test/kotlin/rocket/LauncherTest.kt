package rocket

import org.junit.jupiter.api.Test

class LauncherTest {
    @Test
    fun givenExpiredLaunchCodes_MissileIsNotLaunched_Mock() {
        val mockRocket = MockRocket()

        Launcher.launchRocket(mockRocket, ExpiredLaunchCode(), FakeUsedLaunchCodesRepo())

        mockRocket.verifyCodeRedAbort()
    }

    @Test
    fun givenUnsignedLaunchCodes_MissileIsNotLaunched_Mock() {
        val mockRocket = MockRocket()

        Launcher.launchRocket(mockRocket, UnsignedLaunchCode(), FakeUsedLaunchCodesRepo())

        mockRocket.verifyCodeRedAbort()
    }

    @Test
    fun givenGoodLaunchCodes_RocketIsLaunched() {
        // arrange - 準備
        val mockRocket = MockRocket()

        // act - 実行
        Launcher.launchRocket(mockRocket, GoodLaunchCode(), FakeUsedLaunchCodesRepo())

        // assert - 確認
        mockRocket.verifyLaunch()
    }

    @Test
    fun givenReusedLaunchCode_CodeRedAbort() {
        val mockRocket1 = MockRocket()
        val mockRocket2 = MockRocket()
        val goodLaunchCode: LaunchCode = GoodLaunchCode()
        val usedLaunchCodesRepo: UsedLaunchCodesRepo = FakeUsedLaunchCodesRepo()

        Launcher.launchRocket(mockRocket1, goodLaunchCode, usedLaunchCodesRepo)
        Launcher.launchRocket(mockRocket2, goodLaunchCode, usedLaunchCodesRepo)

        mockRocket2.verifyCodeRedAbort()
    }
}