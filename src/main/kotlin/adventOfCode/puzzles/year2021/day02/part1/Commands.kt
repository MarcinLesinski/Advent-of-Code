package adventOfCode.puzzles.year2021.day02.part1

sealed class Command(protected val value: Int, protected val position: Position){
    abstract fun run()
}

class Forward(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.horizontal += value
    }
}

class Up(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.depth -= value
    }
}

class Down(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.depth += value
    }
}
