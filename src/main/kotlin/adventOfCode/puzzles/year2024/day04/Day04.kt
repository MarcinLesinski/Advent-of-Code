package adventOfCode.puzzles.year2024.day04

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import java.lang.IndexOutOfBoundsException

@Year(2024)
@Day(4, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {

        val nodes =  input.lines().map {line ->
            line.map {ch -> Node(value = ch) }
        }

        nodes.indices.forEach { y ->
            (nodes[0].indices).forEach {x ->
                val node = nodes[y][x]
                node.left = takeNode(x - 1, y, nodes)
                node.right = takeNode(x + 1, y, nodes)
                node.up = takeNode(x, y - 1, nodes)
                node.down = takeNode(x, y + 1, nodes)
                node.upLeft = takeNode(x - 1, y - 1, nodes)
                node.upRight = takeNode(x + 1, y - 1, nodes)
                node.downLeft = takeNode(x - 1, y + 1, nodes)
                node.downRight = takeNode(x + 1, y + 1, nodes)
            }
        }

        var result = 0
        nodes.indices.forEach { y ->
            (nodes[0].indices).forEach {x ->
                result += traceFromPoint(x, y, nodes)
            }}

        return result
    }
}



@Year(2024)
@Day(4, 2)
class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val nodes =  input.lines().map {line ->
            line.map {ch -> Node(value = ch) }
        }

        nodes.indices.forEach { y ->
            (nodes[0].indices).forEach {x ->
                val node = nodes[y][x]
                node.left = takeNode(x - 1, y, nodes)
                node.right = takeNode(x + 1, y, nodes)
                node.up = takeNode(x, y - 1, nodes)
                node.down = takeNode(x, y + 1, nodes)
                node.upLeft = takeNode(x - 1, y - 1, nodes)
                node.upRight = takeNode(x + 1, y - 1, nodes)
                node.downLeft = takeNode(x - 1, y + 1, nodes)
                node.downRight = takeNode(x + 1, y + 1, nodes)
            }
        }

        var result = 0
        nodes.indices.forEach { y ->
            (nodes[0].indices).forEach {x ->
                result += traceXFromPoint(x, y, nodes)
            }}

        return result
    }
}

class Node(
    var right: Node? = null,
    var left: Node? =  null,
    var up: Node? =  null,
    var down: Node? =  null,
    var upRight: Node? =  null,
    var upLeft: Node? =  null,
    var downRight: Node? =  null,
    var downLeft: Node? =  null,
    val value: Char
)

fun takeNode(x: Int, y: Int, nodes: List<List<Node>>): Node? {
    if ((x < 0) or (y < 0)) return null

    val node = try {
        nodes[y][x]
    } catch (e: IndexOutOfBoundsException) {
        null
    }

    return node
}

fun traceXFromPoint(x: Int, y: Int, nodes: List<List<Node>>): Int {

    val node: Node = nodes[y][x]
    if (node.value != 'A') return 0

    val diagonal1 = ((node.upLeft?.value == 'M') and (node.downRight?.value == 'S')) or
            ((node.upLeft?.value == 'S') and (node.downRight?.value == 'M'))

    val diagonal2 = ((node.upRight?.value == 'M') and (node.downLeft?.value == 'S')) or
            ((node.upRight?.value == 'S') and (node.downLeft?.value == 'M'))

    return if (diagonal1 and diagonal2)  1 else  0
}

fun traceFromPoint(x: Int, y: Int, nodes: List<List<Node>>): Int {
    val directions = listOf(
        { n: Node? -> n?.left },          // Left
        { n: Node? -> n?.right },         // Right
        { n: Node? -> n?.up },            // Up
        { n: Node? -> n?.down },          // Down
        { n: Node? -> n?.upLeft },        // Up-Left
        { n: Node? -> n?.upRight },       // Up-Right
        { n: Node? -> n?.downLeft },      // Down-Left
        { n: Node? -> n?.downRight }      // Down-Right
    )

    var result = 0

    for (direction in directions) {
        if (trace(x, y, nodes, direction)) {
            result++
        }
    }

    return result
}

fun trace(x: Int, y: Int, nodes: List<List<Node>>, operation: (Node?) -> Node?): Boolean {
    var node: Node? = nodes[y][x]
    var word = ""
    (1..4).map {
        word += node?.value
        node = operation(node)
    }
    return word == "XMAS"
}