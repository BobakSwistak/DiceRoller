package inputs.bindings

import inputs.KeyCombination
import java.awt.event.KeyEvent

object GameBindings {
    val space = setOf(KeyCombination(KeyEvent.VK_SPACE))
    val plus = setOf(KeyCombination(KeyEvent.VK_EQUALS))
    val minus = setOf(KeyCombination(KeyEvent.VK_MINUS))

}