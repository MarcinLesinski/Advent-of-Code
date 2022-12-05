package adventOfCode.puzzles.year2022.day05

import adventOfCode.common.hasCommonPartWith
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers

@Year(2022)
@Day(5, 2)
internal class Day05Part2(input: RawInput): Puzzle<String>(input)  {
    override fun solve(): String {
        val stacks = stacks()

        input.asLines()
            .map {
                val parts = it.split("move ", " from ", " to ")
                Move(parts[1].toInt(), parts[2].toInt(), parts[3].toInt())
            }
            .forEach { instr ->
                val top = stacks[instr.from]!!.takeLast(instr.count)
                stacks[instr.from] = stacks[instr.from]!!.dropLast(instr.count)
                stacks[instr.to] += top
            }

        val result = stacks.values.map {
            it.takeLast(1)
        }.reduce { ac, item ->
            ac + item
        }

        return result
    }
}
