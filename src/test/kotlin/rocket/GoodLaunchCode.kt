package rocket

class GoodLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return false
    }
}
