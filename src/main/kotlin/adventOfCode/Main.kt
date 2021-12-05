package adventOfCode

import adventOfCode.application.ProgramArguments
import adventOfCode.application.ProgramStartError
import adventOfCode.application.printProgramInputError
import adventOfCode.common.exceptionsUtil.Failure
import adventOfCode.common.exceptionsUtil.Success
import adventOfCode.common.exceptionsUtil.Try
import adventOfCode.common.readRawInput
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.Year
import adventOfCode.domain.solve
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import io.github.classgraph.ClassGraph
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor

fun main(args: Array<String>) {
    mainBody {
        ArgParser(args).parseInto(::ProgramArguments).run {
            val day = day.toInt()
            val part = part.toInt()
            val year = year.toInt()

            val input = readRawInput(year, day)

            val puzzle: Try<Puzzle<Any>> = Try { getPuzzleCtor(year, day, part).call(input) as Puzzle<Any> }

            when (puzzle) {
                is Success -> solve(day, part) {
                    puzzle.get()
                }
                is Failure -> printProgramInputError(year, day, part, puzzle.error)
            }
        }
    }
}

fun getPuzzleCtor(year: Int, day: Int, part: Int): KFunction<Puzzle<*>> {
    val dayAnnotationName = Day::class.qualifiedName
    val yearAnnotationName = Year::class.qualifiedName

    val classes = ClassGraph()
        .enableAllInfo()
        .acceptPackages("adventOfCode.puzzles")
        .scan()
        .getClassesWithAnnotation(yearAnnotationName)

    val yearClasses = classes.filter {
        val yearAnnotation = it.getAnnotationInfo(yearAnnotationName).loadClassAndInstantiate() as Year
        yearAnnotation.value == year
    }

    if (classes.isEmpty()) throw ProgramStartError("We dont' have any solutions for $year year. ...yet")

    val puzzleClass = yearClasses
        .filter {
            val dayAnnotation = it.getAnnotationInfo(dayAnnotationName).loadClassAndInstantiate() as Day
            dayAnnotation.day == day && dayAnnotation.part == part
        }

    if (puzzleClass.isEmpty()) throw ProgramStartError("We didn't implement this puzzle yet")

    @Suppress("UNCHECKED_CAST")
    val puzzleCtor = puzzleClass.first().loadClass().kotlin.primaryConstructor as KFunction<Puzzle<*>>

    return puzzleCtor
}
