package adventOfCode.puzzles.year2020


import adventOfCode.puzzles.year2020.day02.part1.InputParser
import adventOfCode.puzzles.year2020.Day02Part1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day02Part1Test {

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1-3 a: abcde", true),
                Arguments.of("1-3 b: cdefg", false),
                Arguments.of("2-9 c: ccccccccc", true)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun example(input: String, expected: Boolean) {
        val puzzleRule = InputParser.parse(input)
        val actual = Day02Part1.isPasswordValid(puzzleRule)

        assertEquals(expected, actual)
    }

}
