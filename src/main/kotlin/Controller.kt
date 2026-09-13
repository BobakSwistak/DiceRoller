import appTerminal.*
import engine.terminal.Terminal
import frame.FrameCoordinator
import inputs.InputHandler
import engine.ui.UiLayerManager
import save.SaveManager
import java.awt.event.KeyEvent


object Controller {
    fun run() {
        SaveManager.loadSettings()
        terminal = Terminal(137, 52, "Dice Roller", SaveManager.currentSaveSettingsData.screenScale)
        InputHandler.onMenuKey = this::handleMenuKey
        InputHandler.onTechCommand = TechController::command
        terminal.addKeyHandler(InputHandler::handleKey)
        
    }

    fun handleMenuKey(e: KeyEvent): Boolean {
        val result = UiLayerManager.current.handleKey(e)
        FrameCoordinator.refreshFrame()
        return result
    }
    
}