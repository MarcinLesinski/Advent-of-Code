package adventOfCode.puzzles.year2022.day09

import adventOfCode.domain.Lines
import adventOfCode.domain.RawInput
import adventOfCode.domain.asLines

sealed interface Step

object Left : Step
object Right : Step
object Up : Step
object Down : Step

class Line {
    val head = Head()
    val tail = Tail()
    fun move(step: Step) {
        head.move(step)
        tail.follow(head.coords)
    }
}

class LongLine {
    val head = Head()
    val knot1 = Tail()
    val knot2 = Tail()
    val knot3 = Tail()
    val knot4 = Tail()
    val knot5 = Tail()
    val knot6 = Tail()
    val knot7 = Tail()
    val knot8 = Tail()
    val tail = Tail()
    fun move(step: Step) {
        head.move(step)
        knot1.follow(head.coords)
        knot2.follow(knot1.coords)
        knot3.follow(knot2.coords)
        knot4.follow(knot3.coords)
        knot5.follow(knot4.coords)
        knot6.follow(knot5.coords)
        knot7.follow(knot6.coords)
        knot8.follow(knot7.coords)
        tail.follow(knot8.coords)
    }
}

class Head {
    val coords = Coords()

    fun move(step: Step) {
        when (step) {
            Down -> coords.y += 1
            Left -> coords.x -= 1
            Right -> coords.x += 1
            Up -> coords.y -= 1
        }
    }
}

class Tail {
    val coordsWithHistory = CoordsWithHistory()
    val coords get() = Coords(coordsWithHistory.x, coordsWithHistory.y)
    fun follow(head: Coords) {

        val xDelta = head.x - this.coordsWithHistory.x
        val yDelta = head.y - this.coordsWithHistory.y
        val imOnLeft = (xDelta > 1)
        val imOnRight = (xDelta < -1)
        val imOnBot = (yDelta < -1)
        val imOnUp = (yDelta > 1)
        val xDiff = imOnLeft or imOnRight
        val yDiff = imOnBot or imOnUp
        if (xDiff.not() and yDiff.not()) return

        var x = head.x
        var y = head.y

        if (imOnBot) {
            y += 1
        }
        if (imOnUp) {
            y -= 1
        }
        if (imOnLeft) {
            x -= 1
        }
        if (imOnRight) {
            x += 1
        }
        coordsWithHistory.set(x, y)
    }
}

data class Coords(var x: Int = 0, var y: Int = 0) {
    override fun toString(): String {
        return "$x:$y"
    }
}

class CoordsWithHistory {
    private var _x = 0
    private var _y = 0
    val x: Int get() = _x
    val y: Int get() = _y
    private val _history = mutableListOf(Coords(x, y))
    val history get() = _history.toList() // deep immutable copy immutable //List(_history.size){_history[it].copy()}
    fun set(x: Int, y: Int) {
        _history.add(Coords(x, y))
        _x = x
        _y = y
    }
}

// parser ----
fun debugSteps(lines: Lines): List<Step> {
    return lines.map {
        val parts = it.split(" ")
        StepLine(parts[0], parts[1].toInt())
    }.map { stepLine ->
        val step = when (stepLine.direction) {
            "R" -> Right
            "L" -> Left
            "U" -> Up
            "D" -> Down
            else -> error("parse error")
        }
        List(stepLine.steps) { step }
    }.flatten()
}

fun steps(input: RawInput): List<Step> {
    return input.trim().asLines().map {
        val parts = it.split(" ")
        StepLine(parts[0], parts[1].toInt())
    }.map { stepLine ->
        val step = when (stepLine.direction) {
            "R" -> Right
            "L" -> Left
            "U" -> Up
            "D" -> Down
            else -> error("parse error")
        }
        List(stepLine.steps) { step }
    }.flatten()
}

data class StepLine(
    val direction: String,
    val steps: Int,
)

//012345
//...... -5
//..##.. -4
//...##. -3
//....#. -2
//....#. -1
//####..  0

//......
//......
//....H.
//...21.
//43....
