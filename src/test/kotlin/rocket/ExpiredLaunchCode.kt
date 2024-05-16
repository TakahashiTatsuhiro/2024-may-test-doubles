package rocket

class ExpiredLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return true
    }

    override fun isSigned(): Boolean {
        return true
    }
}
