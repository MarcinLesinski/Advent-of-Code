package adventOfCode.puzzles.day8

import adventOfCode.puzzles.day8.commands.Command
import adventOfCode.puzzles.day8.commands.IterationInspector

class LoopDetector {

    fun detect(commands: List<Command> ): Result {
            val executedCommandIndices: MutableSet<Int> = mutableSetOf()
            val iterationInspector = IterationInspector()
            do{
                val loop = !executedCommandIndices.add(iterationInspector.nextCommandIndex)
                if (loop)
                    break
                else
                    commands[iterationInspector.nextCommandIndex]
                        .execute(iterationInspector)
                println("lp:${iterationInspector.steps} id:${executedCommandIndices.last()}, ${iterationInspector.commandLog} - acc:${iterationInspector.accumulator}" )
            } while(true)

        return Result(iterationInspector.accumulator, executedCommandIndices.size)
    }

}

data class Result(val accumulator: Int, val correctSteps: Int)