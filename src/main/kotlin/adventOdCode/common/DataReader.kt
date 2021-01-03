package adventOdCode.common

import adventOdCode.domain.RawInput
import java.io.File

class DataReader {
    companion object {
        fun readDataAsIntegers(fileName: String): List<Int> = readData(fileName).map { it.toInt() }


        fun readData(day: Int): List<String>{
            val fileName = "/day$day.data"
            return readData(fileName)
        }

        private fun readData(fileName: String): List<String> {
            val absoluteFileName = object {}.javaClass.getResource(fileName).file
            return File(absoluteFileName).useLines { it.filter{!it.isEmpty()}.toList() }
        }
    }
}

fun readInput(day: Int): RawInput = DataReader.readData(day)

