package data

import kotlin.random.Random

class Die() {
    var number: Int = 1
    init {
        shuffle()
    }
    fun shuffle() {
        number = Random.nextInt(0, 6)
    }
}