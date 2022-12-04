package adventOfCode.puzzles.year2022.day02

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class Day04Part2Test {

    private lateinit var puzzle: Day02Part2

    @BeforeAll
    fun beforeAll(){
        val data = DataReader.readRawData(2022, 2)
        puzzle = Day02Part2(data)
    }

    @Test
    fun example() {
        val actual = puzzle.solve()

        Assertions.assertEquals(13448, actual)
    }
}
