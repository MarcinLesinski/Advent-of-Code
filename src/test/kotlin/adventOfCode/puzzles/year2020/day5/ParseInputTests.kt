package adventOfCode.puzzles.year2020.day5

import adventOfCode.puzzles.year2020.day5.common.parseInput
import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ParseInputTests {

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("F", "0"),
                Arguments.of("R", "1"),
                Arguments.of("B", "1"),
                Arguments.of("L", "0"),
                Arguments.of("FBRL", "0110"),
                Arguments.of("FFBBRRLL", "00111100")
            )
        }
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun example(input: String, expected: String) {
        val actual = parseInput(input)
        assertEquals(expected, actual)
    }
}
