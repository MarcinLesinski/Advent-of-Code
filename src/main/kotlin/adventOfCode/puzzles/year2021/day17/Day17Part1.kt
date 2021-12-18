package adventOfCode.puzzles.year2021.day17

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import kotlin.math.max

@Year(2021)
@Day(17, 1)
internal class Day17Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val horizontalTarget = (20..30)
        val verticalTarget = (-179..-124)
        var initialSpeed = 0
        var maxHeight = 0

        try {
            do {
                val vhit = hitVertical(0, initialSpeed, verticalTarget)

                if (vhit.hit) {
                    maxHeight = max(maxHeight, vhit.maxHeight)
                    println(maxHeight)
                }
                initialSpeed += 1
            } while (initialSpeed < Int.MAX_VALUE)
        } catch (e: Exception) {

        }
        return maxHeight
    }
}

fun allVerticalSpeeds(target: IntRange): List<Speed> {
    var speed = target.first
    val speeds = mutableListOf<Speed>()
    try {
        do {
            val hit = hitVertical(0, speed, target)
            if (hit.hit) {
                hit.steps.forEach{
                    speeds.add(Speed(speed, it))
                }
            }
            speed += 1
        } while (speed < Int.MAX_VALUE)
    } catch (e: Exception) {

    }
    return speeds
}

//fun allSpeeds(verticalTarget: IntRange, horizontalTarget: IntRange): List<Speed> {
//
//
//}

data class Speed(val value: Int, val step: Int)

fun allHorizontalSpeeds(target: IntRange): List<Speed> {
    var speed = 0
    val speeds = mutableListOf<Speed>()
    try {
        do {
            val hit = hitHorizontal(0, speed, target)
            if (hit.hit) {
                hit.steps.forEach {
                    speeds.add(Speed(speed, it))
                }
            }
            speed += 1
        } while (speed < target.last + 1)
    } catch (e: Exception) {

    }
    return speeds
}

fun hitHorizontal(start: Int, initialVelocity: Int, target: IntRange): Hit {
    val result = Hit()
    var position = start
    var velocity = initialVelocity
    var steps = 0
    do {
        steps += 1
        position += velocity
        velocity -= 1
        if (position in target) {
            result.hit = true
            result.steps.add(steps)
        }

        if(velocity == 0) {
            repeat(500){
                steps +=1
                result.steps.add( steps)
            }
            break
        }

    } while (position < target.last)



    return result
}

fun hitVertical(start: Int, initialVelocity: Int, target: IntRange): Hit {
    val result = Hit()
    var position = start
    var velocity = initialVelocity
    var maxHeight = start
    var steps = 0
    do {
        steps += 1
        position = Math.addExact(position, velocity)
        maxHeight = max(maxHeight, position)
        velocity -= 1
        if (position in target) {
            result.hit = true
            result.maxHeight = maxHeight
            result.steps.add(steps)
        }
    } while (position > target.first)

    return result
}

data class Hit(var maxHeight: Int = Int.MIN_VALUE, var hit: Boolean = false) {
    val steps = mutableListOf<Int>()
}

fun main()  {
    val hspeed = 6
    val vspeed = 9
    val vt = (-10..-5)
    val ht = (20..30)
    val vs = hitVertical(0, vspeed, vt).steps
    val hs = hitHorizontal(0, hspeed, ht).steps
    if (hs== vs)
        println("takie same")
    else
        print("inne !!!!!")


}
