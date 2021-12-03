package adventOfCode.puzzles.year2020.day8.commands

internal class Acc(
    override val value: Int
) : Command {

    override fun execute(iterationInspector: IterationInspector){
        iterationInspector.nextCommandIndex++
        iterationInspector.accumulator += value
        iterationInspector.commandLog = "acc $value"
        iterationInspector.steps ++
    }
}
