package adventOfCode.puzzles.year2023.day05

import adventOfCode.domain.*

@Year(2023)
@Day(5, 1)
internal class Part1(input: RawInput) : Puzzle<Long>(input) {

    override fun solve(): Long {
        val transformers = Transformers(Read.transformers(input))
        var input = Read.input(seeds)

        while (input.kind != "location") {
            val transformer = transformers.get(input)
            input = transformer.transform(input)
        }

        return input.values.min()
    }
}

@Year(2023)
@Day(5, 2)
internal class Part2(input: RawInput) : Puzzle<Long>(input) {
    // answer 60568881
    override fun solve(): Long {

        val transformers = Transformers(Read.transformers(input))

        val inputs = Read.inputAsRanges(seeds)


        var input = inputs
            while (input.kind != "location") {
                val transformer = transformers.get(input)
                input = transformer.transform(input)
            }

        return input.ranges.sortedBy { it.from }. minOf { it.from }

    }
}

typealias From = String
typealias To = String

