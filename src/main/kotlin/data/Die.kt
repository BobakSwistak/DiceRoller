package data

import kotlin.random.Random

class Die() {
    var number: Int = 1

    fun shuffle() {
        number = Random.nextInt(1, 6)
    }
}