package inputs

import inputs.bindings.TechBindings
import java.awt.event.KeyEvent

object InputHandler {
    
    sealed class TechCommand {
        object Exit : TechCommand()
        object IncreaseScale : TechCommand()
        object DecreaseScale : TechCommand()
    }
    
    var onMenuKey: ((KeyEvent) -> Boolean)? = null
    var onTechCommand: ((TechCommand) -> Unit)? = null
    
    fun handleKey(e: KeyEvent) {
        if (handleTechKey(e)) return
        onMenuKey?.invoke(e)
    }
    
    private fun handleTechKey(e: KeyEvent): Boolean {
        when {
            e.matchesAny(TechBindings.exit) -> onTechCommand?.invoke(TechCommand.Exit)
            e.matchesAny(TechBindings.decreaseScale) -> onTechCommand?.invoke(TechCommand.DecreaseScale)
            e.matchesAny(TechBindings.increaseScale) -> onTechCommand?.invoke(TechCommand.IncreaseScale)
            else -> return false
        }
        return true
    }
}