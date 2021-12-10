package adventOfCode.puzzles.year2021.day10

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import java.util.ArrayDeque

@Year(2021)
@Day(10, 2)
internal class Day10Part2(input: RawInput) : Puzzle<Long>(input) {
    override fun solve(): Long {
        val scores = input.asLines().filter{isCorrupted(it).not()}.map(::scoreIncomplete).sorted()
        return scores[((scores.size - 1) / 2)]
    }
}

fun scoreIncomplete(line: String): Long {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf('<' to '>', '(' to ')', '[' to ']', '{' to '}')
    line.forEach { ch ->
        if (ch in arrayOf('<', '(', '[', '{'))
            stack.push(ch)
        else {
            if (pairs[stack.first] == ch)
                stack.pop()
        }
    }
    var result = 0L
    while (stack.isEmpty().not()){
        val ch = stack.pop()
        val closeBracket = pairs[ch]
        val points = when(closeBracket){
          ')' -> 1
          ']' -> 2
          '}' -> 3
          '>' -> 4
          else -> error("")
        }
        result = (result * 5L) + points

    }
    return result
}
