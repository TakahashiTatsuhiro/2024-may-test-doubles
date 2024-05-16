package rocket

class Launcher {
    companion object {
        fun launchRocket(rocket: Rocket, launchCode: LaunchCode) {
            if (!launchCode.isExpired()) {
                rocket.launch()
            }
        }
    }
}