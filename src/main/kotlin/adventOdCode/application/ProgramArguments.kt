package adventOdCode.application

import com.xenomachina.argparser.ArgParser

class ProgramArguments(parser: ArgParser) {

        val day by parser.storing(
            "-d", "--day",
            help = "number of puzzle day")

        val part by parser.storing(
            "-p", "--part",
            help = "part of puzzle - only 1 and 2 are allowed")


}