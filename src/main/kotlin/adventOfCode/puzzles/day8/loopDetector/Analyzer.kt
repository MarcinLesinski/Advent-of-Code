package adventOfCode.puzzles.day8.loopDetector

import adventOfCode.puzzles.day8.commands.Command
import adventOfCode.puzzles.day8.commands.IterationInspector

class Analyzer(private val loopDetector: (Int) -> DetectResult) {

    fun analyze(commands: List<Command>): Result {
        val iterationInspector = IterationInspector()
        do {
            val loop = loopDetector(iterationInspector.nextCommandIndex)
            when (loop) {
                DetectResult.DETECTED -> {
                    return Result(iterationInspector.accumulator, true)
                }
                DetectResult.NOT_YET_DETECTED -> {
                    commands[iterationInspector.nextCommandIndex]
                        .execute(iterationInspector)
                }
                DetectResult.FAILED -> {
                    return Result(iterationInspector.accumulator, false)
                }
            }
        } while (true)
    }
}

data class Result(val accumulator: Int, val success: Boolean)