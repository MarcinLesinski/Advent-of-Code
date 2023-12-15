package adventOfCode.puzzles.year2023.day05

import adventOfCode.common.Range
import adventOfCode.common.Ranges

data class Transformer(
    val from: From,
    val to: To,
    val ranges: List<DomainRange>
) {
    fun transform(input: Input): Input {
        val values = input.values.map { value ->
            val delta = ranges.firstOrNull { it.fit(value) }?.delta ?: 0
            value + delta
        }

        return Input(
            to,
            values
        )
    }

    fun transform(input: InputBasedOnRanges): InputBasedOnRanges {

        val result = mutableListOf<InputRange>()

        input.ranges.forEach { inputRange ->
            val mutableInput = Ranges(Range(inputRange.from, inputRange.to))

            ranges.forEach { range ->
                val output: List<InputRange> = range.transform(inputRange, mutableInput)
                result.addAll(output)
            }

            result.addAll(mutableInput.ranges.map{InputRange(it.from, it.to)})

        }

        return InputBasedOnRanges(
            to,
            result
        )
    }

    private fun findLacking(sources: List<InputRange>, done: List<InputRange>): List<InputRange> {
        val result = mutableListOf<InputRange>()
        sources.forEach { source ->
            val r = source.toRange()
            val rs = Ranges(r)
            done.forEach{rs.draw(it.toRange())}
            rs.ranges.map{InputRange(it.from, it.to)}.also { result.addAll(it) }
        }
        return result
    }
}
