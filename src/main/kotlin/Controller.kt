import appTerminal.*
import art.dice
import data.data
import engine.terminal.Terminal
import frame.FrameCoordinator
import inputs.InputHandler
import engine.ui.UiLayerManager
import inputs.bindings.GameBindings
import inputs.matchesAny
import render.Renderer
import save.SaveManager
import java.awt.event.KeyEvent
import kotlin.concurrent.timer


object Controller {
    fun run() {
        SaveManager.loadSettings()
        terminal = Terminal(
            dice.diceWidth * 3,
            dice.diceHeight * 2,
            "Dice Roller",
            SaveManager.currentSaveSettingsData.screenScale
        )
        InputHandler.onMenuKey = this::handleMenuKey
        InputHandler.onTechCommand = TechController::command
        terminal.addKeyHandler(InputHandler::handleKey)

    }

    fun handleMenuKey(e: KeyEvent): Boolean {
        when {
            e.matchesAny(GameBindings.plus) -> {
                data.diceCount += 1
            }

            e.matchesAny(GameBindings.minus) && data.diceCount > 1 -> {
                data.diceCount -= 1
            }

            e.matchesAny(GameBindings.space) -> {
                data.shuffleDice = true
            }

            else -> return false
        }
        FrameCoordinator.refreshFrame()
        return true
    }

}