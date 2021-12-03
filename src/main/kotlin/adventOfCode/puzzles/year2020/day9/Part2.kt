package adventOfCode.puzzles.year2020.day9

import adventOfCode.common.exceptionsUtil.Try
import adventOfCode.common.sumsTo
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2020) @Day(9, 2)
class Part2(input: RawInput) : Puzzle<Long>(input) {
    var expectedValue = 10884537L

    override fun solve(): Long {

        for (size in 2 until input.lines().size) {
            val tryFindElement = Try {
                input
                    .contiguousSets(size)
                    .first { it.sumsTo(expectedValue) }
            }

            if (tryFindElement.isSuccess())
                return tryFindElement.get().identifier()

        }
        error("no solution found")
    }

    private val RawInput.contiguousSets: (size: Int) -> List<List<Long>>
        get() = { size: Int ->
            lines()
                .map(String::toLong)
                .windowed(size)
        }

    private fun List<Long>.identifier() = min()!! + max()!!
}
