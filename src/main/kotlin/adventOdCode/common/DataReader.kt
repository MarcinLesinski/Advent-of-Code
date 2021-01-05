package adventOdCode.common

import adventOdCode.domain.Lines
import java.io.File

class DataReader {
    companion object {
        fun readDataAsIntegers(fileName: String): List<Int> = readData(fileName).map { it.toInt() }


        fun readData(day: Int): List<String>{
            val fileName = "/day$day.data"
            return readData(fileName)
        }

        fun readRawData(day: Int): String{
            val fileName = "/day$day.data"
            return readRawData(fileName)
        }

        fun readData(fileName: String): List<String> {
            val absoluteFileName = object {}.javaClass.getResource(fileName).file
            return File(absoluteFileName).useLines { it.filter{ it.isNotEmpty() }.toList() }
        }

        fun readRawData(fileName: String): String {
            val absoluteFileName = object {}.javaClass.getResource(fileName).file
            return File(absoluteFileName).readText()
        }
    }
}

fun readInput(day: Int): Lines = DataReader.readData(day)
fun readRawInput(day: Int): String = DataReader.readRawData(day)
