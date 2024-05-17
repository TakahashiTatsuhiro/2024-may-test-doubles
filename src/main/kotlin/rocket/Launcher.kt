package rocket

class Launcher {
    companion object {
        fun launchRocket(rocket: Rocket, launchCode: LaunchCode, usedLaunchCodeRepo: UsedLaunchCodeRepo){
            if (launchCode.isExpired() || !launchCode.isSigned() || usedLaunchCodeRepo.contains(launchCode)) {
                rocket.disable()
            } else {
                rocket.launch()
                usedLaunchCodeRepo.add(launchCode)
            }
        }
    }

}