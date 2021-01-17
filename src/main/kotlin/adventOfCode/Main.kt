package adventOfCode

import adventOfCode.application.ProgramArguments
import adventOfCode.application.printProgramInputError
import adventOfCode.common.exceptionsUtil.Failure
import adventOfCode.common.exceptionsUtil.Success
import adventOfCode.common.exceptionsUtil.Try
import adventOfCode.common.readInput
import adventOfCode.common.readRawInput
import adventOfCode.domain.*
import adventOfCode.puzzles.*
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import io.github.classgraph.ClassGraph
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.primaryConstructor


fun main(args: Array<String>) {
    mainBody {
        ArgParser(args).parseInto(::ProgramArguments).run {
            val day = day.toInt()
            val part = part.toInt()

            val input = readRawInput(day)

            val puzzle: Try<Puzzle<Any>> = Try{getPuzzleCtor(day, part).call(input) as Puzzle<Any>}

            when(puzzle){
                is Success -> solve(day, part) {
                    puzzle.get()
                }
                is Failure -> printProgramInputError(day, part, puzzle.error)
            }
        }
    }
}

fun getPuzzleCtor(day: Int, part: Int): KFunction<Puzzle<*>> {
    val annotationName = Day::class.qualifiedName
    val classes = ClassGraph()
        .enableAllInfo()
        .acceptPackages("adventOfCode.puzzles")
        .scan()
        .getClassesWithAnnotation(annotationName)

    val puzzleClass = classes
        .first {
            val annotation = it.getAnnotationInfo(annotationName).loadClassAndInstantiate() as Day
            annotation.day == day && annotation.part == part
        }
        .loadClass()
        .kotlin

        @Suppress("UNCHECKED_CAST")
         val puzzleCtor = puzzleClass.primaryConstructor as KFunction<Puzzle<*>>

        return puzzleCtor
}