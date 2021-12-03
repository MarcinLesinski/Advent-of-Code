package adventOfCode.application

import com.importre.crayon.bold
import com.importre.crayon.red
import com.importre.crayon.underline

fun printProgramInputError(year: Int, day: Int, part: Int, e: Throwable){
    val yearText = "$year".underline()
    val dayText = day.toString().bold()
    val partText = part.toString().bold()

    println("*** Advent of code $yearText ***")
    println("Puzzle Day $dayText - part $partText")
    if (e is ProgramStartError)
        println(e.message.red().bold())
    else {
        println("Something gone wrong, check your input parameters.".red().bold())
        println("You can also investigate or report ${e.toString().red().bold()}")
    }
}

class ProgramStartError(override val message: String): RuntimeException(message)
