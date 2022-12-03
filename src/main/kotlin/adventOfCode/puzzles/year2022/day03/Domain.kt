package adventOfCode.puzzles.year2022.day03

fun points(char: Char): Int = if(char.isUpperCase()) char.toInt() .minus(64).plus(26) else char.toInt().minus(96)
