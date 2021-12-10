package adventOfCode.puzzles.year2021.day10

import java.util.ArrayDeque

fun corruptedChar(line: String): Char? {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf('<' to '>', '(' to ')', '[' to ']', '{' to '}')
    var wrongChar: Char? = null
    line.forEach { ch ->
        if (ch in arrayOf('<', '(', '[', '{'))
            stack.push(ch)
        else {
            if (pairs[stack.first] == ch)
                stack.pop()
            else {
                if(wrongChar == null)
                    wrongChar = ch
            }
        }
    }
    return wrongChar
}

fun isCorrupted(line: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf('<' to '>', '(' to ')', '[' to ']', '{' to '}')
    var result = false
    line.forEach { ch ->
        if (ch in arrayOf('<', '(', '[', '{'))
            stack.push(ch)
        else {
            if (pairs[stack.first] == ch)
                stack.pop()
            else {
                result = true
            }
        }
    }
    return result
}
