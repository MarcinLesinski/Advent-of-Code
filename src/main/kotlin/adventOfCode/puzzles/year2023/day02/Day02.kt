package adventOfCode.puzzles.year2023.day02

import adventOfCode.domain.*


@Year(2023)
@Day(2, 1)
internal class Day02Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val games = parse(input.asLines())

        return games.filter{
            it.exceedLimit(12, 13, 14).not()
        }.sumOf { it.id }.toInt()

    }
}


@Year(2023)
@Day(2, 2)
internal class Day02Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val games = parse(input.asLines())

        return games.sumOf { it.power() }.toInt()

    }

}
