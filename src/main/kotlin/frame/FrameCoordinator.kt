package frame

import render.Renderer

object FrameCoordinator {
    fun refreshFrame() {
        Updater.update()
        Renderer.render()
    }
}