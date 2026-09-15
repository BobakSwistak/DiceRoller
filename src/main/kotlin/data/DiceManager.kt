package data

object DiceManager {
    var diceCount = 6
    var shuffleDice = false

    var cols = 1
    var rows = 1

    val dice = mutableListOf(Die())

    fun updateDice() {
        while (dice.size < diceCount) {
            dice.add(Die())
        }
        while (dice.size > diceCount) {
            dice.removeAt(diceCount)
        }
        if (shuffleDice) {
            shuffleDice = false

            for (die in dice) {
                die.shuffle()
            }
        }
    }
}