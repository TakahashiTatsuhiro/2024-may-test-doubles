package rocket

class Launcher {
    companion object {
        fun launchRocket(rocket: Rocket, launchCode: LaunchCode, usedLaunchCodesRepo: UsedLaunchCodesRepo) {
            if (usedLaunchCodesRepo.contains(launchCode) || launchCode.isExpired() || !launchCode.isSigned()) {
                rocket.disable()
            } else {
                usedLaunchCodesRepo.add(launchCode)
                rocket.launch()
            }
        }
    }
}