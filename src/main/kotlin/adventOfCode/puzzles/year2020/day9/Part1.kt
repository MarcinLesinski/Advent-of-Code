package adventOfCode.puzzles.year2020.day9

import adventOfCode.common.sumsTo
import adventOfCode.common.unique
import adventOfCode.domain.*

@Year(2020) @Day(9, 1)
class Part1(input: RawInput) : Puzzle<Long>(input) {

    var preambleLength: Int = 25

    override fun solve(): Long {
        val numbers = input.lines().map(String::toLong)
        val dataLines = numbers
            .windowed(preambleLength + 1, 1)
            .map { Data(it[preambleLength], it.subList(0, preambleLength)) }

        return dataLines
            .first{ !it.valid() }
            .value
    }
}

private data class Data(val value: Long, val preamble: List<Long>){
    fun valid(): Boolean {
        return preamble.pairs().any{ pair -> pair.sumsTo(value) && pair.unique() }
    }
}
