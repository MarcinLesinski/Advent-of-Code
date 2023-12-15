package adventOfCode.common

import kotlin.math.max
import kotlin.math.min


class Ranges(
    vararg ranges: Range
) {
    private val _ranges = mutableListOf<Range>().apply { this.addAll(ranges) }
    val ranges get() = _ranges

    fun draw(range: Range): List<Range> {
        val drawsResult = this._ranges.map{
            it.draw(range)
        }

        val drews = drawsResult.mapNotNull { it.drew }
        val rest = drawsResult.map{it.rest}.flatten()
        _ranges.clear()
        _ranges.addAll(rest)

        return drews
    }
}

data class Range(
    private var _from: Long,
    private var _to: Long
) {
    val from get() = _from
    val to get() = _to

    fun draw(range: Range): DrawResult {
        val forceDrew = Range(max(_from, range.from), min(to, range.to))

        val drew = if (forceDrew.isValid) forceDrew else null

        val rest = if (drew == null)
            listOf(this)
        else
            this.minus(range)

        return DrawResult(
            drew,
            rest
        )

    }

    fun minus(range: Range): List<Range> {
        if (this.intersect(range).not())
            return listOf(this)

        val left = Range(_from, range.from - 1)
        val right = Range(range.to + 1, _to)

        val result = mutableListOf<Range>()
        if (left.isValid) result.add(left)
        if (right.isValid) result.add(right)
        return result
    }

    infix fun intersect(range: Range): Boolean {
        return (_from <= range.to) and (range.from <= _to)
    }

    private val isValid get() = to - from >= 0

    data class DrawResult(
        val drew: Range?,
        val rest: List<Range>
    )
}