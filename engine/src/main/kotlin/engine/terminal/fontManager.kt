package engine.terminal

import java.awt.Font

fun loadFont(path: String, size: Float): Font {
    
    val fontStream = object {}.javaClass.getResourceAsStream(path)
        ?: throw RuntimeException("Font not found: $path")
    val font = Font.createFont(Font.TRUETYPE_FONT, fontStream)
    return font.deriveFont(size)
    
}