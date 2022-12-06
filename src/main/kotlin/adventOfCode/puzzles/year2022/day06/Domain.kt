package adventOfCode.puzzles.year2022.day06

fun unique(text: String): Boolean {
    return text.map { a -> text.count{ b -> a == b } }.all{it == 1}
}
