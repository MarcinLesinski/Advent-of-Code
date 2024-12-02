package adventOfCode.puzzles.year2023.day08

import adventOfCode.domain.RawInput


fun read(input: RawInput): Int  {
//    val instruction = input.lines()[0].map{ if (it == 'L') Direction.LEFT else Direction.RIGHT   }
    return 1;
}


class Maze() {


}

class Choice() {
    fun insert(left: Choice, right: Choice) {
        this.left = left
        this.right = right
    }

    private lateinit var left: Choice
    private lateinit var right: Choice

    fun goLeft(): Choice = left
    fun goRight(): Choice = right
}

enum class Direction {
    LEFT, RIGHT
}