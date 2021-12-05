package adventOfCode.puzzles.year2021.day01

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Part2Test {
    private lateinit var puzzle: Day01Part2

    @BeforeAll
    fun beforeAll() {
        val data = DataReader.readRawData(2021, 1)
        puzzle = Day01Part2(data)
    }

    @Test
    fun example() {
        val actual = puzzle.solve()

        Assertions.assertEquals(5, actual)
    }
}
