package render

import appTerminal.*
import data.ColorPalette

object ImageRenderer {
    fun renderCenteredImage(
        image: List<String>, color: ColorPalette = ColorPalette.WHITE
    ) {
        if (image.isEmpty()) return
        
        val verticalOffset = (terminal.getHeight() - image.size) / 2
        val horizontalOffset = (terminal.getWidth() - image[0].length) / 2
        renderOffsetImage(image, color, horizontalOffset, verticalOffset)
    }
    
    fun renderOffsetImage(
        image: List<String>, color: ColorPalette = ColorPalette.WHITE, offsetX: Int = 0, offsetY: Int = 0
    ) {
        if (image.isEmpty()) return
        
        terminal.setBgColor(ColorPalette.BLACK)
        terminal.setFgColor(color)
        
        for (i in image.indices) {
            terminal.write(image[i], offsetX, offsetY + i)
        }
    }
}