package adventOfCode.puzzles

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07Part2Test {

    @Test
    fun sample1(){
        val input = DataReader.readRawData("day7_sample.data")

        val actual = Day07Part2(input).solve()
        assertEquals(32, actual )
    }

    @Test
    fun sample2(){
        val input = DataReader.readRawData("day7B_sample.data")

        val actual = Day07Part2(input).solve()
        assertEquals(126, actual )
    }
}

