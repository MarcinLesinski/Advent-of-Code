package adventOfCode.common

import adventOfCode.domain.Lines
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
            val fixedFileName = if (fileName.startsWith("/")) fileName  else "/$fileName"
            val absoluteFileName = object {}.javaClass.getResource(fixedFileName).file
            return File(absoluteFileName).useLines { it.toList() }
        }

        fun readRawData(fileName: String): String {
            val fixedFileName = if (fileName.startsWith("/")) fileName  else "/$fileName"
            val absoluteFileName = object {}.javaClass.getResource(fixedFileName).file
            return File(absoluteFileName).readText()
        }
    }
}

fun readInput(day: Int): Lines = DataReader.readData(day)
fun readRawInput(day: Int): String = DataReader.readRawData(day)
