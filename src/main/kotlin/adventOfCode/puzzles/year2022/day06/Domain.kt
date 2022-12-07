package adventOfCode.puzzles.year2022.day06

fun unique(text: String): Boolean {
    text.indices.forEach{
        val duplicate = text.drop(it+1).contains(text[it])
        if (duplicate) return false
    }
    return true


//    return text.map { a -> text.count{ b -> a == b } }.all{it == 1}
}
