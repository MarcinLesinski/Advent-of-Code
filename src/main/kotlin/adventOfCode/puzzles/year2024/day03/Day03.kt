package adventOfCode.puzzles.year2024.day03

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2024)
@Day(3, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)")
        val muls = regex.findAll(input)
        val res = muls.toList().sumOf {
            val numbers = it.value.split("mul(",",", ")")
            numbers[1].toInt() * numbers[2].toInt()
        }

        return res
    }
}

@Year(2024)
@Day(3, 2)
class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val regex = Regex("mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\)")
        val muls = regex.findAll(input)

        var doo = true
        var sum = 0
        muls.toList().forEach {
            println(it.value)
            when {
                it.value == "do()" -> doo = true
                it.value == "don't()" -> doo = false
                else -> if (doo) {
                    val numbers = it.value.split("mul(",",", ")")
                    sum +=  numbers[1].toInt() * numbers[2].toInt()
                }
            }
        }

        return sum
    }
}