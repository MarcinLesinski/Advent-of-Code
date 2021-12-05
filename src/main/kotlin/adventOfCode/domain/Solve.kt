package adventOfCode.domain

import kotlin.system.measureNanoTime
import com.importre.crayon.*
import java.text.SimpleDateFormat

fun <TResult: Any> solve(year: Int, day: Int, part: Int, block: () -> Puzzle<TResult>) {
    var result: TResult? = null

    val executionTimeInNanoSeconds = measureNanoTime {
        result = block().solve()
    }

    result?.let{
        printReport(year, day, part, it, executionTimeInNanoSeconds)
    }

}

private fun printReport(year: Int, day: Int, part: Int, result: Any, executionTimeInNanoSeconds: Long){
    val yearText = year.toString().underline()
    val dayText = day.toString().bold()
    val partText = part.toString().bold()
    val executionTimeText = SimpleDateFormat("mm:ss:SSS" ).format(executionTimeInNanoSeconds / 1000000f)
    println()
    println("*** Advent of code $yearText ***")
    println("Puzzle Day $dayText - part $partText")
    println("answer is:")
    println('\t' + result.toString().bgBrightBlue().yellow())
    println()
    println("execution time: $executionTimeText")
}

