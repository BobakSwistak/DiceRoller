package engine.ui

import java.awt.event.KeyEvent

interface UiLayer {
    val id: Any
    val blocksLowerLayers: Boolean
    
    fun render()
    
    //return true if this layer consumed the key
    fun handleKey(e: KeyEvent): Boolean
}