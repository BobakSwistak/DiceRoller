package frame

import appTerminal.terminal

object FrameCoordinator {
    fun refreshFrame() {
        terminal.write("A", 0, 0)
    }
}