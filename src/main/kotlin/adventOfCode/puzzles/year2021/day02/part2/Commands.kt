package adventOfCode.puzzles.year2021.day02.part2

sealed class Command(protected val value: Int, protected val position: Position){
    abstract fun run()
}

class Forward(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.horizontal += value
        position.depth += position.aim * value
    }
}

class Up(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.aim -= value
    }
}

class Down(value: Int, position: Position): Command(value, position) {
    override fun run() {
        position.aim += value
    }
}
