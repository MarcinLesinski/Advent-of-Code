package adventOfCode.puzzles.year2023.day05

import adventOfCode.common.Range
import adventOfCode.common.Ranges
import kotlin.math.max
import kotlin.math.min

class DomainRange(
    destinationRangeStart: Long,
    sourceRangeStart: Long,
    range: Long,
) {
    var from = sourceRangeStart
    var to = sourceRangeStart + range
    var delta = destinationRangeStart - sourceRangeStart

    fun fit(number: Long): Boolean = number in from..to


    fun transform(inputRange: InputRange, ranges: Ranges): List<InputRange> {


        val left = InputRange(inputRange.from,  from - 1)
        val mid = InputRange( max(inputRange.from, from), min(inputRange.to, to))
        val right = InputRange(to + 1, inputRange.to,)

        val result = mutableListOf<InputRange>()

        if (left.isValid(inputRange.from, inputRange.to)) {
            ranges.draw(Range(left.from, left.to))
            result.add(left)
        }
        if (mid.isValid(inputRange.from, inputRange.to)) {
            ranges.draw(Range(mid.from, mid.to))
            result.add(mid.copy(from = mid.from + delta, to = mid.to + delta) )
        }
        if (right.isValid(inputRange.from, inputRange.to)) {
            ranges.draw(Range(right.from, right.to))
            result.add(right)
        }

//        if (result.isEmpty()) result.add(inputRange)
        return result
    }

}

