package rocket

class UnsignedLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return true
    }

    override fun isSigned(): Boolean {
        return false
    }

}
