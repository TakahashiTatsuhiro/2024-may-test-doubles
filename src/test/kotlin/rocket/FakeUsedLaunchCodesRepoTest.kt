package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FakeUsedLaunchCodesRepoTest {

    @Test
    fun addedLaunchCode_containsTrue() {
        val fakeUsedLaunchCodesRepo = FakeUsedLaunchCodesRepo()
        val launchCode: LaunchCode = GoodLaunchCode()

        fakeUsedLaunchCodesRepo.add(launchCode)

        assertTrue(fakeUsedLaunchCodesRepo.contains(launchCode))
    }

    @Test
    fun notAddedLaunchCode_containsFalse() {
        val fakeUsedLaunchCodesRepo = FakeUsedLaunchCodesRepo()
        val launchCode: LaunchCode = GoodLaunchCode()

        assertFalse(fakeUsedLaunchCodesRepo.contains(launchCode))
    }

    @Test
    fun addedDifferentLaunchCode_containsFalse() {
        val fakeUsedLaunchCodesRepo = FakeUsedLaunchCodesRepo()
        val launchCode: LaunchCode = GoodLaunchCode()

        fakeUsedLaunchCodesRepo.add(launchCode)

        val differentLaunchCode: LaunchCode = GoodLaunchCode()
        assertFalse(fakeUsedLaunchCodesRepo.contains(differentLaunchCode))
    }
}