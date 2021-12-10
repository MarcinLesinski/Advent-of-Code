package adventOfCode.puzzles.year2021.day09

data class Cords(val row: Int, val col: Int) {
    fun left(): Cords = this.copy(col = col - 1)
    fun right(): Cords = this.copy(col = col + 1)
    fun top(): Cords = this.copy(row = row - 1)
    fun bot(): Cords = this.copy(row = row + 1)
}

