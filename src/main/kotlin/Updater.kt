import appTerminal.terminal
import art.dice
import data.DiceManager
import kotlin.math.sqrt

object Updater {
    fun update() {
        DiceManager.updateDice()

        DiceManager.cols = sqrt(DiceManager.diceCount.toDouble()).toInt()
        DiceManager.rows = (DiceManager.diceCount + DiceManager.cols - 1) / DiceManager.cols
        terminal.setSize(DiceManager.cols * dice.diceWidth + 1, DiceManager.rows * dice.diceHeight + 1)

    }
}