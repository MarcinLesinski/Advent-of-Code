package adventOfCode.puzzles.year2023.day06

import adventOfCode.domain.*
import java.math.BigInteger

@Year(2023)
@Day(6, 1)
internal class Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val times = input.lines()[0].split(' ').filter(String::isNotBlank).drop(1).map(String::toInt)
        val distances = input.lines()[1].split(' ').filter(String::isNotBlank).drop(1).map(String::toInt)
        val records = times.zip(distances)
        return records
            .map{(time, distance) -> solutions(time, distance)}
            .map{it.count()}
            .reduce{acc, i ->  acc * i}

    }
}

fun solutions(time: Int, distance: Int): List<Int> {
    val calcResult = {n: Int -> n * (time - n)}
    return (1..time).map(calcResult).filter{it > distance}
}

@Year(2023)
@Day(6, 2)
internal class Part2(input: RawInput) : Puzzle<Long>(input) {

    override fun solve(): Long {
        val time = 47847467L
        val distance = 207139412091014L

//        val time = BigInteger.valueOf(71530L)
//        val distance = BigInteger.valueOf(940200L)
//        val time = 71530L
//        val distance = 940200L


        val calcResult = {n: Long -> n * (time - n)}

        val first = (1..time).first{calcResult(it) > distance}
        val last = (time downTo 1).first{calcResult(it) > distance}

        return last - first + 1
    }
}
