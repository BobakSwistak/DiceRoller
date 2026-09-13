package engine.ui

object UiLayerManager {
    val stack = mutableListOf<UiLayer>()
    
    val current: UiLayer
        get() = stack.last()
    
    fun open(layer: UiLayer) {
        if (stack.none { it.id == layer.id }) {
            stack.add(layer)
        }
    }
    
    fun back() {
        if (stack.size > 1) {
            stack.removeLast()
        }
    }
}