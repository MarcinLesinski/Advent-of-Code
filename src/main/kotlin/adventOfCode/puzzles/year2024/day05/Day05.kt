package adventOfCode.puzzles.year2024.day05

import adventOfCode.common.withRemovedAt
import adventOfCode.domain.*
import kotlin.text.split

@Year(2024)
@Day(5, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val parts = input.split("\r\n\r\n")
        val ruleLines = parts[0].split("\r\n")
        val rules = ruleLines.map { line ->
                val (a, b) = line.split('|')
                a.toInt() to b.toInt()
        }
        var rulesMap = rules.groupBy({it.first}, {it.second})
        //---
        var sequences = parts[1].split("\r\n").map { it.split(',').map(String::toInt) }

        val validNumbers = sequences.map { seq ->
            var valid = true
            seq.forEachIndexed{index, item ->
                val mustBeAfter = rulesMap[item]!!
                val before = seq.take(index)
                if(before.intersect(mustBeAfter).isNotEmpty())
                    valid = false
            }
            if (valid) {seq[seq.size / 2] } else 0

        }
        return validNumbers.sum()
    }
}

@Year(2024)
@Day(5, 2)
class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val parts = input.split("\r\n\r\n")
        val ruleLines = parts[0].split("\r\n")
        val rules = ruleLines.map { line ->
            val (a, b) = line.split('|')
            a.toInt() to b.toInt()
        }
        var rulesMap = rules.groupBy({it.first}, {it.second})
        //---
        var sequences = parts[1].split("\r\n").map { it.split(',').map(String::toInt) }

        val validNumbers = sequences.map { seq ->
            var valid = isValid(seq, rulesMap)
            val fixed: List<Int> = fix(seq, rulesMap)
            if (isValid(fixed, rulesMap).not()) {
                throw Error("WRONG!")
            }

            if (valid.not()) {fixed[fixed.size / 2] } else 0

        }
        return validNumbers.sum()
    }

    private fun isValid(
        seq: List<Int>,
        rulesMap: Map<Int, List<Int>>
    ): Boolean {
        var valid = true
        seq.forEachIndexed { index, item ->
            val mustBeAfter = rulesMap[item]!!
            val before = seq.take(index)
            if (before.intersect(mustBeAfter).isNotEmpty())
                valid = false
        }
        return valid
    }

    private fun fix(seq: List<Int>, rulesMap: Map<Int, List<Int>>): List<Int> {
        val result = mutableListOf<Int>()
        val basic = seq.toMutableList()
        while (true) {
            for (i in basic.indices.reversed()) {
                if (isFirst(basic[i], basic.withRemovedAt(i), rulesMap)) {
                    result.add(basic[i])
                    basic.removeAt(i)
                }
            }

            if (basic.size == 0) {
                return result
            }
        }
    }

    private fun isFirst(item: Int, rest: List<Int>, rulesMap: Map<Int, List<Int>>): Boolean {
        return rest.all{ rulesMap[item]!!.contains(it) }
    }
}