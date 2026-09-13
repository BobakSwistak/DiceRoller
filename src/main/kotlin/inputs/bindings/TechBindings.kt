package inputs.bindings

import inputs.KeyCombination
import java.awt.event.KeyEvent

object TechBindings {
    val exit = setOf(KeyCombination(KeyEvent.VK_Q, ctrl = true))
    val decreaseScale = setOf(KeyCombination(KeyEvent.VK_MINUS, ctrl = true))
    val increaseScale = setOf(KeyCombination(KeyEvent.VK_EQUALS, ctrl = true))
}