package adventOfCode.puzzles.day5.part1

import adventOfCode.puzzles.day5.common.SeatDecoder

fun findHighestIDSeat(binarySpacePartitioningList: List<String>): Int{

         return binarySpacePartitioningList
             .map{ SeatDecoder(7, 3).decode(it) }
             .max() ?: 0

    }