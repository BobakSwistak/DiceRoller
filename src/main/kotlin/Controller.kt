import appTerminal.*
import art.dice
import data.DiceManager
import engine.terminal.Terminal
import frame.FrameCoordinator
import inputs.InputHandler
import inputs.bindings.GameBindings
import inputs.matchesAny
import save.SaveManager
import java.awt.event.KeyEvent


object Controller {
    fun run() {
        SaveManager.loadSettings()
        terminal = Terminal(
            dice.diceWidth * 3 + 1,
            dice.diceHeight * 2 + 1,
            "Dice Roller - By Bobak Świstak",
            SaveManager.currentSaveSettingsData.screenScale
        )
        InputHandler.onMenuKey = this::handleMenuKey
        InputHandler.onTechCommand = TechController::command
        terminal.addKeyHandler(InputHandler::handleKey)

        FrameCoordinator.refreshFrame()

    }

    fun handleMenuKey(e: KeyEvent): Boolean {
        when {
            e.matchesAny(GameBindings.plus) -> {
                DiceManager.diceCount += 1
            }

            e.matchesAny(GameBindings.minus) && DiceManager.diceCount > 1 -> {
                DiceManager.diceCount -= 1
            }

            e.matchesAny(GameBindings.space) -> {
                DiceManager.shuffleDice = true
            }

            else -> return false
        }
        FrameCoordinator.refreshFrame()
        return true
    }

}