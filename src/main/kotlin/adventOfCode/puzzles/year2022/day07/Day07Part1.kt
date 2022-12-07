package adventOfCode.puzzles.year2022.day07

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2022)
@Day(7, 1)
internal class Day07Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val dirs = tree(input)

        return dirs.all
            .filter {it.hasSizeAtMost100k}
            .sumOf { it.size() }
            .toInt()
    }

    private val Dir.hasSizeAtMost100k get() =this.size() <= 100_000

}


