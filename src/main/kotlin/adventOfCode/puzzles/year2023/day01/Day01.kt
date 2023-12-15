package adventOfCode.puzzles.year2023.day01

import adventOfCode.domain.*


@Year(2023)
@Day(1, 1)
internal class Day01Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val result = input.asLines().map { line ->
            val numbers = line.filter { char -> char.isDigit() }
            val first = numbers.first().digitToInt()
            val last = numbers.last().digitToInt()
            first * 10 + last
        }.sum()

        return result
    }
}

data class DigitInfo(
    val name: String,
    val value: Int,
    var first: Int? = null,
    var last: Int? = null,
)

@Year(2023)
@Day(1, 2)
internal class Day01Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val result = input.asLines()
            .map {line ->
                val digitsInfo = listOf(
                    DigitInfo("one", 1),
                    DigitInfo("two", 2),
                    DigitInfo("three", 3),
                    DigitInfo("four", 4),
                    DigitInfo("five", 5),
                    DigitInfo("six", 6),
                    DigitInfo("seven", 7),
                    DigitInfo("eight", 8),
                    DigitInfo("nine", 9),
                    DigitInfo("1", 1),
                    DigitInfo("2", 2),
                    DigitInfo("3", 3),
                    DigitInfo("4", 4),
                    DigitInfo("5", 5),
                    DigitInfo("6", 6),
                    DigitInfo("7", 7),
                    DigitInfo("8", 8),
                    DigitInfo("9", 9),
                )

                digitsInfo.forEach { digit ->
                    digit.first = line.indexOf(digit.name)
                    digit.last = line.lastIndexOf(digit.name)
                }
                digitsInfo
            }
            .map { info ->
                val first = info
                    .filter{ it.first != -1 }
                    .minBy { it.first!! }
                    .value

                val last = info
                    .filter{ it.last != -1 }
                    .maxBy { it.last!! }
                    .value

                first * 10 + last
            }.sum()

        return result
    }

}
