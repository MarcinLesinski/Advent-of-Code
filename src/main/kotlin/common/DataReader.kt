package common

import java.io.File

class DataReader {
    companion object {
        fun readDataAsIntegers(fileName: String): List<Int> = readData(fileName).map { it.toInt() }

        fun readData(fileName: String): List<String> {
            val absoluteFileName = object {}.javaClass.getResource(fileName).file
            return File(absoluteFileName).useLines { it.toList() }
        }
    }
}


