package data

import kotlinx.serialization.Serializable
import java.awt.Color

@Serializable
enum class ColorPalette(val rgb: Int) {
    WHITE(0xFFFFFF),
    LIGHT_GRAY(0xE6E6E6),
    GRAY(0x7F7F7F),
    BLACK(0x000000),
    
    GREEN(0x6EFF00),
    YELLOW(0xFFC800),
    ORANGE(0xFF6400),
    RED(0xFF0000),
    CYAN(0x00FFFF),
    
    LIGHT_BROWN(0xB26619),
    DARK_BROWN(0x66330C);
    
    fun toAwtColor(): Color = Color(rgb)
}