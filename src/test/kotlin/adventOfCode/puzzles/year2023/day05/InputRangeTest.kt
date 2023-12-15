package adventOfCode.puzzles.year2023.day05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class InputRangeTest{


    fun test(from: Long, to: Long): Boolean{
        val base = InputRange(10, 20)
        val sub = InputRange(from, to)
        return sub.isValid(base.from, base.to)
    }

    @Test
    fun a(){
        assert(test(10, 20))
    }

    @Test
    fun b(){
        assert(test(11, 20))
    }

    @Test
    fun c(){
        assert(test(10, 19))
    }

    @Test
    fun d(){
        assert(test(11, 19))
    }


    @Test
    fun e(){
        assert(test(9, 20).not())
    }

    @Test
    fun f(){
        assert(test(10, 21).not())
    }

    @Test
    fun g(){
        assert(test(9, 21).not())
    }

    @Test
    fun h(){
        assert(test(1, 9).not())
    }

    @Test
    fun i(){
        assert(test(21, 30).not())
    }


}