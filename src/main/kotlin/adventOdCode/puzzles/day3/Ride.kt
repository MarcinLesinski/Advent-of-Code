package adventOdCode.puzzles.day3

data class Ride(val right: Int, val down: Int) {

    override fun toString(): String {
        return "Ride $right $down"
    }

    private fun points(): Sequence<Ride> {
        return generateSequence(this) { Ride(it.right + right, it.down + down) }
    }

    fun steps(takeWhile: (Ride) -> Boolean): List<Ride> {
        return this
            .points()
            .takeWhile(takeWhile)
            .toList()
    }
}