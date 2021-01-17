package adventOfCode.application

import com.importre.crayon.bold
import com.importre.crayon.red
import com.importre.crayon.underline

fun printProgramInputError(day: Int, part: Int, e: Throwable){
    val yearText = "2020".underline()
    val dayText = day.toString().bold()
    val partText = part.toString().bold()

    println("*** Advent of code $yearText ***")
    println("Puzzle Day $dayText - part $partText")
    println("Something gone wrong, check your input parameters.".red().bold())
    println("You can also investigate or report ${e.toString().red().bold()}")
}