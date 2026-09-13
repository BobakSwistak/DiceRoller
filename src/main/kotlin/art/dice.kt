package art

object dice {
    val diceHeight = 6
    val diceWidth = 6
    val die1 =
        """-----
           |   |
           | o |
           |   |
           -----""".trimIndent().lines().map { it.trim() }.map { it.trim() }

    val die2 =
        """-----
           |o  |
           |   |
           |  o|
           -----""".trimIndent().lines().map { it.trim() }
    val die3 =
        """-----
           |o  |
           | o |
           |  o|
           -----""".trimIndent().lines().map { it.trim() }
    val die4 =
        """-----
           |o o|
           |   |
           |o o|
           -----""".trimIndent().lines().map { it.trim() }
    val die5 =
        """-----
           |o o|
           | o |
           |o o|
           -----""".trimIndent().lines().map { it.trim() }
    val die6 =
        """-----
           |o o|
           |o o|
           |o o|
           -----""".trimIndent().lines().map { it.trim() }

    fun getDice(number: Int): List<String> {
        when (number % 6+1) {
            1 -> return die1
            2 -> return die2
            3 -> return die3
            4 -> return die4
            5 -> return die5
            6 -> return die6
        }
        return die1
    }
}