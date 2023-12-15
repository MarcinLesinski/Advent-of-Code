package adventOfCode.puzzles.year2023.day02

import adventOfCode.common.sumByLong


data class Occurrences(
    val color: String,
    val occurs: Long
) {
    override fun toString(): String {
        return "$occurs $color"
    }
}

typealias Sequence = List<Occurrences>

data class Game(
    val id: Long,
    val sequences: List<Sequence>
) {
    fun exceedLimit(redLimit: Long, greenLimit: Long, blueLimit: Long): Boolean {
        val blues = sequences.flatten().filter{it.color == "blue"}.maxOf { it.occurs }
        val reds = sequences.flatten().filter{it.color == "red"}.maxOf { it.occurs }
        val greens = sequences.flatten().filter{it.color == "green"}.maxOf { it.occurs }

        return (blueLimit < blues) or (redLimit < reds) or (greenLimit < greens)
    }

    fun power(): Long {
        val blues = sequences.flatten().filter{it.color == "blue"}.maxOf { it.occurs }
        val reds = sequences.flatten().filter{it.color == "red"}.maxOf { it.occurs }
        val greens = sequences.flatten().filter{it.color == "green"}.maxOf { it.occurs }
        return  blues * greens * reds
    }

    fun sums(): String {
        val blues = sequences.flatten().filter{it.color == "blue"}.maxOf { it.occurs }
        val reds = sequences.flatten().filter{it.color == "red"}.maxOf { it.occurs }
        val greens = sequences.flatten().filter{it.color == "green"}.maxOf { it.occurs }

        return "red:$reds green:$greens blue:$blues"
    }
}

fun parse(lines: List<String>): List<Game> {
    return lines.map{ line ->
        val gameId = getGameId(line)
        val seq = getSequences(line)
        Game(gameId, seq)
    }
}

fun getGameId(line: String): Long {
    val gameX = line.split(":")[0]
    val idAsText = gameX.split(" ")[1]
    return idAsText.toLong()
}

fun getSequences(line: String): List<Sequence> {
    val seqAsText = line.split(": ")[1].split("; ")
    return seqAsText.map{
        val countColors = it.split(", ")
        countColors.map{`count - color` ->
             val count = `count - color`.split(" ")[0].toLong()
             val color = `count - color`.split(" ")[1]
            Occurrences(color, count)
        }.toList()
    }
}