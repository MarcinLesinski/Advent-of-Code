package adventOfCode.puzzles.year2021.day12

open class Node(val name: String) {
    protected var _entries = 0
    private val ways = mutableListOf<Node>()

    fun add(node: Node) {
//        println("add: " + name + "   " + node.name)
        ways.add(node)
    }

    open fun run(chain: String, wildcard: Boolean) {
        _entries += 1
//        println("$chain,$name")
        ways.forEach{
            it.run("$chain,$name", wildcard)
        }
    }
}

class SmallNode(name: String): Node(name) {
    override fun run(chain: String, wildcard: Boolean) {
        if (chain.contains(",$name").not()){
            super.run(chain, wildcard)
        } else {
            if (wildcard){
                super.run(chain, false)
            }
        }
    }
}

class StartNode(name: String): Node(name) {

    override fun run(chain: String, wildcard: Boolean) {
        if (chain.contains(",$name").not()){
            super.run(chain, wildcard)
        } else {
            println("fail: $chain,$name")
        }
    }
}

class BigNode(name: String): Node(name) {

}

class EndNode(name: String) : Node(name){
    fun entries() = _entries

    override fun run(chain: String, wildcard: Boolean){
        _entries += 1
        println("$chain,$name")
    }
}

class Factory(private val lines: List<String>) {
    private val map = mutableMapOf<String, Node>()
    fun start(): Node = map["start"]!!
    fun end(): EndNode = map["end"]!! as EndNode
    fun construct(part: Int) {
        when (part) {
            1 -> map["start"] = SmallNode("start")
            2 -> map["start"] = StartNode("start")
        }

        map["end"] = EndNode("end")
        lines.forEach {
            val (from, to) = it.split("-")
            if (map.contains(from).not())  map[from] = node(from)
            if (map.contains(to).not())  map[to] = node(to)

            map[from]!!.add(node(to))
            map[to]!!.add(node(from))
        }
    }

    private fun node(name: String): Node {
        if (map.contains(name))
            return map[name]!!

        return if (name == name.toLowerCase()) {
            SmallNode(name)
        } else {
            BigNode(name)
        }
    }
}
