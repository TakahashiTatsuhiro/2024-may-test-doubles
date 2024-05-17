package rocket

interface UsedLaunchCodeRepo {
    fun contains(launchCode: LaunchCode) :Boolean
    fun add(launchCode: LaunchCode)
}