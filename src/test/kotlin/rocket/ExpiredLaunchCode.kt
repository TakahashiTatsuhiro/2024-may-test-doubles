package rocket

class ExpiredLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return true
    }
}
