package adventOfCode.puzzles.year2022.day07

import adventOfCode.domain.RawInput
import adventOfCode.domain.asLines

sealed class Operation

class Dir(
    val parent: Dir?,
    val name: String
){
    private val _dirs = mutableListOf<Dir>()
    private val _files = mutableListOf<File>()
    fun add(f: File) {
        _files.add(f)
    }
    fun add(d: Dir) {
        _dirs.add(d)
    }

    fun size(): Long {
        return _dirs.sumOf { it.size() } + _files.sumOf { it.size }
    }

    fun goTo(name: String): Dir {
        return if (name == "..") parent!!
        else {_dirs.first { it.name == name }  }
    }
}

class File(val name: String, val size: Long)

fun file(txt: String): File {
    val parts = txt.split(" ")
    val size = parts[0].toLong()
    val name = parts[1]
    return File(name, size)
}

fun cd(txt: String): String {
    val parts = txt.split(" ")
    val name = parts[2]
    return name
}

fun dir(parent: Dir, txt: String): Dir? {
    val parts = txt.split(" ")
    val name = parts[1]
    if (name == "..") return parent.parent
    return Dir(parent, name)
}

enum class LineType{
    DIR, FILE, CD, LS
}

fun lineIs(txt: String): LineType {
    return when{
        txt.startsWith("$ cd") -> LineType.CD
        txt.startsWith("$ ls") -> LineType.LS
        txt.startsWith("dir") -> LineType.DIR
        else -> LineType.FILE
    }
}

fun tree(input: RawInput): DirTree{
    val dirs = mutableListOf<Dir>()
    val root = Dir(null, "/")
    var currentDir = root
    input.asLines().drop(1).forEach {
        when(lineIs(it)){
            LineType.DIR -> {
                val dir =dir(currentDir, it)!!
                dirs.add(dir)
                currentDir.add(dir)
            }
            LineType.FILE -> {
                currentDir.add(file(it))
            }
            LineType.CD -> {
                val name = cd(it)
                currentDir = currentDir.goTo(name)
            }
            LineType.LS -> {}
        }
    }
    return DirTree(root, dirs)
}

class DirTree(
    val root: Dir,
    val all: List<Dir>
)
