package adventOfCode.puzzles.year2021.day17

import adventOfCode.common.multiplyBy
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import com.sun.org.apache.xerces.internal.impl.xpath.XPath
import java.math.BigInteger

@Year(2021)
@Day(17, 2)
internal class Day17Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val v = allVerticalSpeeds(-179..-124)
        val h = allHorizontalSpeeds(70..96)

        val all = mutableListOf< Pair<Int, Int>>()
        v.forEach { vertical ->
            h.forEach {  horizontal ->
                if(vertical.step == horizontal.step) {
                    all.add( vertical.value to horizontal.value )
                }
            }
        }

        val result = v.map{ vertical ->
            h.count { horizontal -> horizontal.step ==  vertical.step }
        }.sum()

        return all.distinct().also{println(it)}.count()
    }

}
