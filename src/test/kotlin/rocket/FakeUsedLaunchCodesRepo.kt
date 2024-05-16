package rocket


class FakeUsedLaunchCodesRepo : UsedLaunchCodesRepo {
    private val set = HashSet<LaunchCode>()

    override fun contains(launchCode: LaunchCode): Boolean {
        return set.contains(launchCode)
    }

    override fun add(launchCode: LaunchCode) {
        set.add(launchCode)
    }
}
