package adventOfCode.puzzles.year2022.day07

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2022)
@Day(7, 2)
internal class Day07Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        val dirs = tree(input)
        val freeSpace = totalDiscSpace - dirs.root.size()

        return dirs.all
            .filter{ freeSpace + it.size() > updateSize }
            .minBy { it.size() }
            .size()
            .toInt()
    }
    private val totalDiscSpace = 70_000_000
    private val updateSize = 30_000_000

}
