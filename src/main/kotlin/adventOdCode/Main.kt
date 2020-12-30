package adventOdCode

import adventOdCode.application.ProgramArguments
import adventOdCode.common.readInput
import adventOdCode.domain.asNumbers
import adventOdCode.domain.solve
import adventOdCode.puzzles.Day01Part1
import adventOdCode.puzzles.Day01Part2
import adventOdCode.puzzles.Day02Part1
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import java.lang.reflect.Modifier
import kotlin.reflect.KFunction
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.jvm.kotlinFunction

fun main(args: Array<String>) {
    mainBody {
        ArgParser(args).parseInto(::ProgramArguments).run {
            val startFunctionName = "day${day}_${part}"
            //TODO find file name dynamicly
            getTopLevelFunctionFromFile("Puzzles", startFunctionName)?.call()
        }
    }
}

// TODO move it to ReflectionUtil file
fun getTopLevelFunctionFromFile(fileName: String, funcName: String): KFunction<*>? {
    val selfRef = ::getTopLevelFunctionFromFile
    val currentClass = selfRef.javaMethod!!.declaringClass
//    println(currentClass.name)
//    val classDefiningFunctions = currentClass.classLoader.loadClass("${fileName}Kt")
    val javaMethod = currentClass.methods.find { it.name == funcName && Modifier.isStatic(it.modifiers) }
    return javaMethod?.kotlinFunction
}

@SuppressWarnings("unused")
//TODO: @Day(1, 1)
fun day1_1() {
    val input = readInput(1).asNumbers()

    solve(1, 1) {
        Day01Part1(input)
    }
}

@SuppressWarnings("unused")
fun day1_2() {
    val input = readInput(1).asNumbers()

    solve(1, 2) {
        Day01Part2(input)
    }
}

@SuppressWarnings("unused")
fun day2_1() {
    val input = readInput(2)

    solve(2, 1) {
        Day02Part1(input)
    }
}