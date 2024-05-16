package rocket


interface UsedLaunchCodesRepo {
    fun contains(launchCode: LaunchCode): Boolean

    fun add(launchCode: LaunchCode)
}