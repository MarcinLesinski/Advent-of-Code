package adventOfCode.puzzles.year2024.day02

import adventOfCode.common.typeExtentions.asLinesOfNumbers
import adventOfCode.common.withRemovedAt
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import kotlin.math.abs

@Year(2024)
@Day(2, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        return input.lines().asLinesOfNumbers().map { lineOfLevels ->
            val stepsAnalysis = lineOfLevels.windowed(2, 1) {
                val prev = it[0]
                val next = it[1]
                Step(
                    distance = abs(prev - next),
                    direction = Direction(prev - next)
                )
            }
            stepsAnalysis
        }.map { steps ->
            val correctDistances = steps.all { it.distance in 1..3 }
            val correctTrend = steps.all { it.direction.get() == "increase" } or
                    steps.all { it.direction.get() == "decrease" }
            correctTrend and correctDistances
        }.count { it }
    }

}

@Year(2024)
@Day(2, 2)
class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {

        val firstStage = input.lines().asLinesOfNumbers().mapIndexed() { index, lineOfLevels ->
            val stepsAnalysis = analiseLine(lineOfLevels)
            IndexedStep(stepsAnalysis, index)
        }
        val validInFirstStage = firstStage.filter { isValid(it.steps) }

        val notValid = firstStage.filter { !isValid(it.steps) }.map { it.indexedStep }
        val secondStage = input.lines().asLinesOfNumbers().filterIndexed { index, ar ->
            notValid.contains(index)
        }

        val allVariantsOfInvalids = secondStage.map { steps ->
            steps.indices.map { index -> steps.withRemovedAt(index) }
        }

        val countsOfBadCombinations = allVariantsOfInvalids.map { variants ->
            val validCount = variants.count { variant ->
                val steps = analiseLine(variant)
                isValid(steps)
            }
            validCount
        }

        val sndChanceCount = countsOfBadCombinations.count { it > 0 }
        return validInFirstStage.count() + sndChanceCount

    }
}

fun analiseLine(line: List<Int>): List<Step> {
    return line.windowed(2, 1) {
        val prev = it[0]
        val next = it[1]
        Step(
            distance = abs(prev - next),
            direction = Direction(prev - next)
        )
    }
}

fun isValid(steps: List<Step>): Boolean {
    val correctDistances = steps.all { it.distance in 1..3 }
    val correctTrend = steps.all { it.direction.get() == "increase" } or
            steps.all { it.direction.get() == "decrease" }
    return correctTrend and correctDistances
}

data class IndexedStep(
    val steps: List<Step>,
    val indexedStep: Int
)

data class Step(
    val distance: Int,
    val direction: Direction
)

class Direction(number: Int) {
    private val direction = when {
        number > 0 -> "decrease"
        number < 0 -> "increase"
        else -> "equals"
    }

    public val get = { direction }
}