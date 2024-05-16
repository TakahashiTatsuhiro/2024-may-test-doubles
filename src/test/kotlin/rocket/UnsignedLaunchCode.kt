package rocket

class UnsignedLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return false
    }

    override fun isSigned(): Boolean {
        return false
    }
}
