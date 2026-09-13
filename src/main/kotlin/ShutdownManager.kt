import appTerminal.*
import kotlin.system.exitProcess

object ShutdownManager {
    fun exit(status: Int = 0, saveDataTrigger: Boolean = true) {
        exitProcess(status)
    }
}