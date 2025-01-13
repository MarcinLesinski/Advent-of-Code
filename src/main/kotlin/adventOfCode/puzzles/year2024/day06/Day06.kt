package adventOfCode.puzzles.year2024.day06

import adventOfCode.common.typeExtentions.asLinesOfNumbers
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2024.day04.takeNode
import java.lang.IndexOutOfBoundsException
import kotlin.math.abs

class Day06 {
    @Year(2024)
    @Day(6, 1)
    class Part1(input: RawInput) : Puzzle<Int>(input) {
        override fun solve(): Int {
            val guard = Guard()
            val nodes = input.lines().mapIndexed { y, line ->
                line.mapIndexed { x, ch ->
                    val node = Node(x, y, if (ch == '#') Kind.Wall else Kind.Corridor)
                    if (ch == '^') guard.setPosition(node)
                    node
                }
            }
            connectNodes(nodes)

            do {
                val moved = guard.move()
            } while (moved == true)

            return nodes.flatten().count { it.visited }
        }
    }

    @Year(2024)
    @Day(6, 2)
    class Part2(input: RawInput) : Puzzle<Int>(input) {
        override fun solve(): Int {
            lateinit var startPosition: Node
            val guard = Guard()
            val nodes = input.lines().mapIndexed { y, line ->
                line.mapIndexed { x, ch ->
                    val node = Node(x, y, if (ch == '#') Kind.Wall else Kind.Corridor)
                    if (ch == '^') {guard.setPosition(node)
                    startPosition = node}
                    node
                }
            }
            connectNodes(nodes)
            var result = 0
            nodes.indices.forEach { y ->
                nodes[y].indices.forEach { x ->
                    nodes[y][x].temporaryObstacle()
                    var moved: Boolean? = null
                    guard.clear(startPosition)
                    do {
                        moved = guard.move()
                    } while (moved == true)
                    if (moved == null) {
                        result++
                    }
                    nodes[y][x].clearTemporaryObstacle()
                }
            }


            return result
        }
    }
}

class Guard {
    private lateinit var node: Node
    private var direction: String = "up"
    private var visited = mutableSetOf<Triple<Int, Int, String>>()
    fun clear(position: Node) {
        visited.clear()
        setPosition(position)
        direction = "up"
    }
    val steps  get() =  visited.count()
    fun setPosition(node: Node) {
        this.node = node
        node.visit()
    }

    // can step forward or turn right
    // return true if any move inside board was made
    fun move(): Boolean? {
        val (nextNode, newDirection) = getNextMove(node, direction)
        return if (nextNode != null) {
            node = nextNode
            direction = newDirection
            nextNode.visit()
            val visitedHash = Triple(node.x, node.y, direction)

            if (visited.contains(visitedHash))
                return null // null means loop detected
            else
                visited.add(visitedHash)
            true
        } else false
    }

    private fun getNextMove(node: Node, direction: String): Pair<Node?, String> {

        // try step forward
        val nextForward = when (direction) {
            "up" -> node.up
            "right" -> node.right
            "down" -> node.down
            "left" -> node.left
            else -> error("invalid state")
        }
        if ((nextForward == null) or (nextForward?.isWalkable() == true)) return nextForward to direction

        // turn right
        val newDirecton = when (direction) {
            "up" -> "right"
            "right" -> "down"
            "down" -> "left"
            "left" -> "up"
            else -> error("invalid state")
        }
        return node to newDirecton
    }

}

//region nodes
fun connectNodes(nodes: List<List<Node>>) {
    nodes.indices.forEach { y ->
        (nodes[y].indices).forEach { x ->
            val node = nodes[y][x]
            node.left = takeNode(x - 1, y, nodes)
            node.right = takeNode(x + 1, y, nodes)
            node.up = takeNode(x, y - 1, nodes)
            node.down = takeNode(x, y + 1, nodes)
        }
    }
}

fun takeNode(x: Int, y: Int, nodes: List<List<Node>>): Node? {
    if ((x < 0) or (y < 0)) return null

    val node = try {
        nodes[y][x]
    } catch (e: IndexOutOfBoundsException) {
        null
    }

    return node
}

//endregion
class Node(
    val x: Int,
    val y: Int,
    val kind: Kind,
) {
    var tempObstacle: Boolean = false

    fun visit() {
        visited = true
    }

    fun temporaryObstacle() {
        tempObstacle = true
    }

    fun clearTemporaryObstacle() {
        tempObstacle = false
    }

    fun isWalkable(): Boolean {
        if (tempObstacle) {
            val i = 0
        }
        return (kind == Kind.Corridor) and !tempObstacle
    }
    var visited = false
    var right: Node? = null
    var left: Node? = null
    var up: Node? = null
    var down: Node? = null

}

enum class Kind {
    Wall, Corridor,
}
