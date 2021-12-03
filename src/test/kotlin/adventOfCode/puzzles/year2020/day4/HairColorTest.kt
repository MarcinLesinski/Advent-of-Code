package adventOfCode.puzzles.year2020.day4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class HairColorTest {

    @ParameterizedTest
    @MethodSource("inputsSource")
    fun examples(value: String, expected: Boolean) {
        if (expected)
            assertDoesNotThrow { HairColor(value) }
        else
            assertThrows(IllegalArgumentException::class.java) { HairColor(value) }
    }

    companion object {
        @JvmStatic
        fun inputsSource(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("#123456", true),
                Arguments.of("#1234af", true),
                Arguments.of("#623a2f", true),
                Arguments.of("#888785", true),
                Arguments.of("#13456", false),
                Arguments.of("123456", false),
                Arguments.of("#12345r", false),
                Arguments.of("#1234567", false)
            )
        }
    }

}
