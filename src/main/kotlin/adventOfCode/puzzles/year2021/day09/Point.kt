package adventOfCode.puzzles.year2021.day09

class Point(val value: Int) {
    var top: Point? = null
    var bot: Point? = null
    var left: Point? = null
    var right: Point? = null
    var inspected = false
    val low: Boolean
        get() {
            val lowestNeighbor = listOfNotNull(top?.value, bot?.value, left?.value, right?.value).min()
            return ( lowestNeighbor == null ) || value < lowestNeighbor
        }
    val edge: Boolean get() = this.value == 9
    val neighbors: List<Point> get() = listOfNotNull(top, bot, left, right)

}
