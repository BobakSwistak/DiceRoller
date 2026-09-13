package inputs

import java.awt.event.KeyEvent

fun KeyEvent.matches(combo: KeyCombination): Boolean {
    return keyCode == combo.keyCode &&
            isControlDown == combo.ctrl &&
            isAltDown == combo.alt &&
            isShiftDown == combo.shift
}

fun KeyEvent.matchesAny(combos: Iterable<KeyCombination>): Boolean {
    return combos.any { matches(it) }
}