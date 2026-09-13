import appTerminal.terminal
import art.dice
import data.data
import kotlin.math.sqrt

object Updater {
    fun update() {
        data.cols = sqrt(data.diceCount.toDouble()).toInt()
        data.rows = (data.diceCount + data.cols - 1) / data.cols
        terminal.setSize(data.cols * dice.diceWidth, data.rows * dice.diceHeight)
        
    }
}