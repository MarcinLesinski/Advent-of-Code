package adventOdCode.puzzles.day3

class Trail(
    private val slope: Slope,
    private val ride: Ride
) {

    fun obstacles(): Int {
        val steps = ride.steps{slope.contains(it.right, it.down) }
        return steps.count { slope[it.right, it.down]}
    }
}