package adventOfCode.puzzles.year2021.day14

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import java.math.BigInteger

@Year(2021)
@Day(14, 2)
internal class Day14Part2(input: RawInput) : Puzzle<BigInteger>(input) {

    override fun solve(): BigInteger {
        var (templateText, insertionsText) = input.split(System.lineSeparator() + System.lineSeparator())
        val template = constructTemplate(templateText)
        val inserts = constructInserts(insertionsText.asLines())
        repeat(40) {
            template.rise(inserts)
        }
        return template.result()
    }
}

class Template(
    private var pairs: MutableMap<String, BigInteger>,
    private val letters: MutableMap<Char, BigInteger>
) {
    fun rise(inserts: Map<String, Char>) {
        val newPairs = mutableMapOf<String, BigInteger>()
        pairs.forEach { pair ->
            val middleChar = inserts[pair.key]!!
            updateLetters(middleChar, pair.value)
            val newPair1 = "${pair.key[0]}${middleChar}"
            val newPair2 = "${middleChar}${pair.key[1]}"
            newPairs[newPair1] = (newPairs[newPair1] ?: BigInteger.ZERO) + pair.value
            newPairs[newPair2] = (newPairs[newPair2] ?: BigInteger.ZERO) + pair.value
        }
        pairs = newPairs
    }

    private fun updateLetters(letter: Char, count: BigInteger) {
        letters[letter] = (letters[letter] ?: BigInteger.ZERO) + count
    }

    fun result(): BigInteger {
        return letters.maxBy { it.value }!!.value - letters.minBy { it.value }!!.value
    }
}

fun constructTemplate(initialString: String): Template {
    val map = mutableMapOf<String, BigInteger>()
    val letters = mutableMapOf<Char, BigInteger>()
    initialString.forEach { ch ->
        letters[ch] = BigInteger(initialString.count { it == ch }.toString())
    }

    initialString.windowed(2, 1).forEach {
        if (map.contains(it)) {
            map[it] = map[it]!!.plus(BigInteger.ONE)
        } else {
            map[it] = BigInteger.ONE
        }
    }
    return Template(map, letters)
}

fun constructInserts(data: List<String>): Map<String, Char> {
    val result = mutableMapOf<String, Char>()
    data.forEach {
        val (left, right) = it.split(" -> ")
        result[left] = right[0]
    }
    return result
}
