package rocket

class Launcher {
    companion object {
        fun launchRocket(rocket: Rocket, launchCode: LaunchCode) {
            try {
                rocket.launch()
            } catch (e: Exception) {

            }
        }
    }
}