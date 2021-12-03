package adventOfCode.application

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import java.time.LocalDateTime

class ProgramArguments(parser: ArgParser) {

        val day by parser.storing(
            "-d", "--day",
            help = "puzzle day")

        val part by parser.storing(
            "-p", "--part",
            help = "part of puzzle - only 1 and 2 are allowed")

        val year by parser.storing(
            "-y", "--year",
            help = "year of advent of code - default is current year"
        ).default(currentYear())
}

fun currentYear(): String {
    return "${LocalDateTime.now().year}"
}
