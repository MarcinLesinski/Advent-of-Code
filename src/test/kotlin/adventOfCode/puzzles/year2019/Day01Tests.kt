package adventOfCode.puzzles.year2019

import adventOfCode.puzzles.year2019.day01.Day01Part1
import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class Day01Tests {
    @ParameterizedTest
    @MethodSource("numberToCalc")
    fun calc(number: Int, expected: Int){
        val actual = Day01Part1("").calc(number)

        Assertions.assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun numberToCalc(): Stream<Arguments> {
            return Stream.of(
                arguments(12, 2),
                arguments(14, 2),
                arguments(1969, 654),
                arguments(100756, 33583)
            )
        }
    }
}
