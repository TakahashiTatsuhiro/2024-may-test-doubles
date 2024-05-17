package rocket

import jdk.jfr.Unsigned
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LauncherTest {

//    @Test
//    fun givenExpiredLaunchCodes_RocketIsNotLaunched() {
//        Launcher.launchRocket(DummyRocket(), ExpiredLaunchCode())
//    }

//    @Test
//    fun givenExpiredLaunchCodes_RocketIsNotLaunched_Spy() {
//        // arrange
//        val spyRocket = SpyRocket()
//
//        // act
//        Launcher.launchRocket(spyRocket, ExpiredLaunchCode())
//
//        // assert
//        assertFalse(spyRocket.launchWasCalled)
//        assertTrue(spyRocket.disableWasCalled)
//    }

//    @Test
//    fun givenUnsignedLaunchCodes_RocketIsNotLaunched_Spy() {
//        // arrange
//        val spyRocket = SpyRocket()
//
//        // act
//        Launcher.launchRocket(spyRocket, UnsignedLaunchCode())
//
//        // assert
//        assertFalse(spyRocket.launchWasCalled)
//        assertTrue(spyRocket.disableWasCalled)
//    }

//    @Test
//    fun givenGoodExpiredLaunchCodes_RocketIsNotLaunched_Spy() {
//        // arrange
//        val spyRocket = SpyRocket()
//
//        // act
//        Launcher.launchRocket(spyRocket, GoodLaunchCode())
//
//        // assert
//        assertTrue(spyRocket.launchWasCalled)
//        assertFalse(spyRocket.disableWasCalled)
//    }

    @Test
    fun givenGoodExpiredLaunchCodes_RocketIsNotLaunched_Mock() {
        // arrange
        val mockRocket = MockRocket()

        // act
        Launcher.launchRocket(mockRocket, GoodLaunchCode(), FakeUsedLaunchCodeRepo())

        // assert
        mockRocket.verifyLaunch()
    }

    @Test
    fun givenExpiredLaunchCodes_RocketIsNotLaunched_Mock() {
        // arrange
        val mockRocket = MockRocket()

        // act
        Launcher.launchRocket(mockRocket,ExpiredLaunchCode(), FakeUsedLaunchCodeRepo())

        // assert
        mockRocket.verifyAbort()
    }

    @Test
    fun givenUnsignedExpiredLaunchCodes_RocketIsNotLaunched_Mock() {
        // arrange
        val mockRocket = MockRocket()

        // act
        Launcher.launchRocket(mockRocket, UnsignedLaunchCode(), FakeUsedLaunchCodeRepo())

        // assert
        mockRocket.verifyAbort()
    }

    @Test
    fun givenReusedLaunchCode_RocketIsNotLaunched_Fake() {
        val mockRocket1 = MockRocket()
        val mockRocket2 = MockRocket()
        val goodLaunchCode = GoodLaunchCode()
        val fakeUsedLaunchCodeRepo = FakeUsedLaunchCodeRepo()

        Launcher.launchRocket(mockRocket1, goodLaunchCode, fakeUsedLaunchCodeRepo)
        Launcher.launchRocket(mockRocket2, goodLaunchCode, fakeUsedLaunchCodeRepo)

        mockRocket1.verifyLaunch()
        mockRocket2.verifyAbort()
    }
}