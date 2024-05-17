package rocket

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class FakeUsedLaunchCodeRepoTest {
    @Test
    fun givenLaunchCodeAdded_containReturnsTrue() {
        val fakeUsedLaunchCodeRepo = FakeUsedLaunchCodeRepo()
        val launchCode = GoodLaunchCode()

        fakeUsedLaunchCodeRepo.add(launchCode)

        assertTrue (fakeUsedLaunchCodeRepo.contains(launchCode))
    }

    @Test
    fun givenLaunchCodeNotAdded_containReturnFalse() {
        val fakeUsedLaunchCodeRepo = FakeUsedLaunchCodeRepo()
        val launchCode = GoodLaunchCode()

        assertFalse (fakeUsedLaunchCodeRepo.contains(launchCode))
    }

    @Test
    fun givenDifferentLaunchCodeAdded_containReturnsFalse() {
        val fakeUsedLaunchCodeRepo = FakeUsedLaunchCodeRepo()
        val launchCode = GoodLaunchCode()

        fakeUsedLaunchCodeRepo.add(launchCode)

        val differentLaunchCode = GoodLaunchCode()
        assertFalse (fakeUsedLaunchCodeRepo.contains(differentLaunchCode))
    }
}