package render

import appTerminal.*
import art.dice
import data.DiceManager

object Renderer {
    fun render() {
//        if (DiceManager.shuffleDice) {
        DiceManager.shuffleDice = false
        terminal.clear()
        var counter = 0
        for (i in 0 until DiceManager.rows) {
            for (j in 0 until DiceManager.cols) {
                ImageRenderer.renderOffsetImage(
                    dice.getDice(DiceManager.dice[counter].number),
                    offsetX = i * dice.diceWidth + 1,
                    offsetY = j * dice.diceHeight + 1
                )
                counter += 1
                if (counter == DiceManager.diceCount) break
            }
        }
        terminal.refresh()
//        }
    }
}
