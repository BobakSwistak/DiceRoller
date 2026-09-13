import inputs.InputHandler
import appTerminal.*

object TechController {
    fun command(techCommand: InputHandler.TechCommand) {
        when (techCommand) {
            is InputHandler.TechCommand.Exit -> ShutdownManager.exit()
            is InputHandler.TechCommand.IncreaseScale -> terminal.increaseScale()
            is InputHandler.TechCommand.DecreaseScale -> terminal.decreaseScale()
        }
    }
}