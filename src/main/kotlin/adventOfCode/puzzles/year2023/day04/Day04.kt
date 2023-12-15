package adventOfCode.puzzles.year2023.day04

import adventOfCode.domain.*

@Year(2023)
@Day(4, 1)
internal class Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val cards = parseLines(input.asLines())
        return cards.map{it.result()}.sum()
    }
}


@Year(2023)
@Day(4, 2)
internal class Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val original = parseLines(input.asLines())
        val gen = ArrayList(original)
        var dumpCounter = 0

        var won = true
        while(won){
            won = false
            val nextGen = mutableListOf<Card>()
            gen.forEach {
                val win = it.play(original)
                if (win.isEmpty())
                    nextGen.add(it)
                else {
                    nextGen.addAll(win)
                    dumpCounter += win.size
                    won = true
                }
            }
            gen.clear()
            gen.addAll(nextGen)
        }

        return dumpCounter + original.size
    }

}

data class Card(
    val number: Int,
    val wining: List<Int>,
    val yours: List<Int>
) {
    fun result(): Int {
        val count = wining.intersect(yours).size
        if (count == 0) return 0

        var result = 1
        repeat(count - 1) {
            result *= 2
        }

        return result
    }

    fun play(cards: List<Card>): List<Card> {
        val count = wining.intersect(yours).size
        val result = mutableListOf<Card>()
        (1..count).forEach{ index ->
            val card = cards.first { it.number == this.number + index }
            result.add(card)
        }
        return result
    }
}

fun parseLines(lines: List<String>): List<Card> {
    return lines.map{ parseLine(it) }
}

fun parseLine(line: String): Card {
    val number = line.split(":")[0].drop(4).trim().toInt()
    println(number)
    val left = line.split(":")[1].split("|")[0]
    val right = line.split(":")[1].split("|")[1]
    val wining = textToNumbers(left)
    val yours = textToNumbers(right)

    return Card(number, wining, yours)
}

fun textToNumbers(line: String): List<Int> {
    return line.split(" ").filter{it.isNotBlank()}.map{it.trim()}.map{it.toInt()}
}