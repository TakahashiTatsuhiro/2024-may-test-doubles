package rocket

class GoodLaunchCode : LaunchCode {
    override fun isExpired(): Boolean {
        return false
    }

    override fun isSigned(): Boolean {
        return true
    }

}
