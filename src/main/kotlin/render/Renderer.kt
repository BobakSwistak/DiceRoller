package render

import appTerminal.*
import art.dice
import data.data
import java.util.Random

object Renderer {
    fun render() {
//        if (data.shuffleDice) {
        data.shuffleDice = false
        terminal.clear()
        var counter = 0
        for (i in 0 until data.rows) {
            for (j in 0 until data.cols) {
                ImageRenderer.renderOffsetImage(
                    dice.getDice(Random().nextInt(1, 6)),
                    offsetX = i * dice.diceWidth,
                    offsetY = j * dice.diceHeight
                )
                counter += 1
                if (counter == data.diceCount) break
            }
        }
        terminal.refresh()
//        }
    }
}
