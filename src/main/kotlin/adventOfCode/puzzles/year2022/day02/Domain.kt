package adventOfCode.puzzles.year2022.day02

class Match(
    private val me: Choose,
    private val you: Choose
) {
    fun play(): Result = me.play(you)
    fun points(): Int = play().points + me.points
    override fun toString(): String {
        return "me: $me, you: $you"
    }
}

enum class Choose {
    ROCK, PAPER, SCISSORS;

    val points
        get() = when (this) {
            ROCK -> 1
            PAPER -> 2
            SCISSORS -> 3
        }

    val wining: Choose
        get() = when (this) {
            ROCK -> PAPER
            PAPER -> SCISSORS
            SCISSORS -> ROCK
        }
    val drawing: Choose get() = this
    val loosing: Choose
        get() = when (this) {
            ROCK -> SCISSORS
            PAPER -> ROCK
            SCISSORS -> PAPER
        }

    fun play(opponentChoose: Choose): Result {
        return when {
            this.wining == opponentChoose -> Result.LOSE
            this.loosing == opponentChoose -> Result.WIN
            this.drawing == opponentChoose -> Result.DRAW
            else -> error("")
        }
    }

    companion object {
        fun of(ch: Char): Choose = when (ch) {
            'A', 'X' -> ROCK
            'B', 'Y' -> PAPER
            'C', 'Z' -> SCISSORS
            else -> error("")
        }
    }
}

enum class Result {
    LOSE {
        override fun suitingChoose(choose: Choose): Choose = choose.loosing
    },
    WIN {
        override fun suitingChoose(choose: Choose): Choose = choose.wining
    },
    DRAW {
        override fun suitingChoose(choose: Choose): Choose = choose.drawing
    };

    val points
        get() = when (this) {
            LOSE -> 0
            WIN -> 6
            DRAW -> 3
        }

    abstract fun suitingChoose(choose: Choose): Choose

    companion object {
        fun of(char: Char): Result =
            when (char) {
                'X' -> LOSE
                'Y' -> DRAW
                'Z' -> WIN
                else -> error("")
            }
    }
}
