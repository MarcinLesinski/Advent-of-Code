package adventOfCode.puzzles.year2020.day5

import adventOfCode.puzzles.year2020.day5.common.SequenceDecoder

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class SequenceDecoderTest {

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("11", 3),
                Arguments.of("111", 7),
                Arguments.of("1000", 8),
                Arguments.of("111111", 63)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun example(sequence: String, expected: Int) {
        val actual = SequenceDecoder(sequence.length).decode(sequence)
        assertEquals(expected, actual)
    }
}
