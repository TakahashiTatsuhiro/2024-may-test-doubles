package rocket

interface LaunchCode {
    fun isExpired() :Boolean
    fun isSigned(): Boolean
}